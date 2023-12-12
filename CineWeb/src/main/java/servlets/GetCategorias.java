package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Categoria;
import logic.CategoriaABMC;

/**
 * Servlet implementation class GetCategorias
 */
@WebServlet("/Admin/Peliculas/GetCategorias")
public class GetCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Categoria> categorias = new LinkedList<>();
		CategoriaABMC cl = new CategoriaABMC();
		categorias = cl.getAll();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("agregarPelicula.jsp").forward(request, response);
	}

}
