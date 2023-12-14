package servlets;

import java.io.IOException;
import java.sql.SQLException;

import entities.Categoria;
import logic.CategoriaABMC;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditarCategoria
 */
@WebServlet("/Admin/Categorias/EditarCategoria")
public class EditarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

    Categoria c = new Categoria();
    CategoriaABMC cl = new CategoriaABMC();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			c.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
			c = cl.searchCategoria(c);
			request.setAttribute("categoria", c);
			request.getRequestDispatcher("/Admin/Categorias/editarCategoria.jsp").forward(request, response);
			
		} catch (SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Categoria> categorias = new LinkedList<Categoria>();
		try {
			c.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
			c = cl.searchCategoria(c);
			if (c!=null) {
			c.setNombreCategoria(request.getParameter("nombre"));
			cl.updateCategoria(c);
			categorias = cl.getAll();
			request.setAttribute("categorias", categorias);
			String mensaje = "Se ha actualizado con exito la categoria";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/Admin/Categorias/MenuCategorias.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
		
	}

}
