package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Categoria;
import entities.Pelicula;
import logic.CategoriaABMC;
import logic.PeliculaABMC;

/**
 * Servlet implementation class EditarPelicula
 */
@WebServlet("/Admin/Peliculas/EditarPelicula")
public class EditarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula pel = new Pelicula();
		pel.setIdPelicula(Integer.parseInt(request.getParameter("idPelicula")));
		PeliculaABMC pl = new PeliculaABMC();
		pel = pl.getOne(pel);
		LinkedList<Categoria> categorias = new LinkedList<>();
		CategoriaABMC cl = new CategoriaABMC();
		categorias = cl.getAll();
		request.setAttribute("categorias", categorias);
		request.setAttribute("editPel", pel);
		request.getRequestDispatcher("editarPelicula.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula pel = new Pelicula();
		pel.setIdPelicula(Integer.parseInt(request.getParameter("idPelicula")));
		PeliculaABMC pl = new PeliculaABMC();
		pel = pl.getOne(pel);
		pel.setNombrePelicula(request.getParameter("nombre"));
		pel.setPortada(request.getParameter("portada"));
		//TODO: PODER ACTUALIZAR LA CATEGORIA
		pl.updatePelicula(pel);
		LinkedList<Pelicula> pelis = new LinkedList<>();
		pelis = pl.getAll();
		System.out.println(pelis);
		request.setAttribute("peliculas", pelis);
		request.getRequestDispatcher("MenuPeliculas.jsp").forward(request, response);
	}

}
