package servlets;


import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PeliculaABMC;
import logic.CategoriaABMC;
import entities.Categoria;
import entities.Pelicula;

/**
 * Servlet implementation class BuscaPelixCat
 */
@WebServlet("/BuscaPelixCat")
public class BuscaPelixCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaPelixCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PeliculaABMC PelABMC = new PeliculaABMC();
		CategoriaABMC CatABMC = new CategoriaABMC();
		Categoria cat = new Categoria();
		int valorVariable = Integer.parseInt(request.getParameter("nombreVariable"));
		System.out.println("Datos recibidos: " + valorVariable);
		cat.setIdCategoria(valorVariable);
		LinkedList<Pelicula> listaPelisxCategoria =PelABMC.getPeliculasxCategoria(CatABMC.searchCategoria(cat));
		request.setAttribute("peliculas", listaPelisxCategoria);
		request.getRequestDispatcher("PelisxCat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
