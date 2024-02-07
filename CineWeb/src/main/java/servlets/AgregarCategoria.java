package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.AppException;
import entities.Categoria;
import logic.CategoriaABMC;
import java.util.LinkedList;


/**
 * Servlet implementation class AgregarCategoria
 */
@WebServlet("/Admin/Categorias/AgregarCategoria")
public class AgregarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categoria c = new Categoria();
		CategoriaABMC cl = new CategoriaABMC();
		LinkedList<Categoria> categorias = new LinkedList<Categoria>();
		try {
			c.setNombreCategoria(request.getParameter("nombre"));
			cl.addCategoria(c);
			categorias = cl.getAll();
			request.setAttribute("categorias", categorias);
			String mensaje = "Se ha agregado con exito la categoria";
			request.setAttribute("mensaje",mensaje);
			request.getRequestDispatcher("MenuCategorias.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", "Hubo un error en la base de datos");
			request.setAttribute("causa", e.getMessage().toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		} catch (AppException e) {
			request.setAttribute("error", "Hubo un error inesperado");
			request.setAttribute("causa", e.getMessage().toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

}
