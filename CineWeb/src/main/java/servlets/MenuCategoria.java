package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Categoria;
import logic.CategoriaABMC;

/**
 * Servlet implementation class MenuCategoria
 */
@WebServlet({ "/Admin/Categorias/MenuCategoria" })
public class MenuCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaABMC cl = new CategoriaABMC();	
		LinkedList<Categoria> categorias = new LinkedList<Categoria>();
		try {
			categorias = cl.getAll();
 			request.setAttribute("categorias", categorias);
 			request.getRequestDispatcher("/Admin/Categorias/MenuCategorias.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
