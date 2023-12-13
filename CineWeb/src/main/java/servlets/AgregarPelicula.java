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
import entities.Pelicula;
import logic.CategoriaABMC;
import logic.PeliculaABMC;

/**
 * Servlet implementation class AgregarPelicula
 */
@WebServlet({ "/Admin/Peliculas/AgregarPelicula" })
public class AgregarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula p = new Pelicula();
		Categoria c = new Categoria();
		CategoriaABMC cl = new CategoriaABMC();
		PeliculaABMC pl = new PeliculaABMC();
		try {
			p.setNombrePelicula(request.getParameter("nombre"));
			c = cl.getOne(Integer.parseInt(request.getParameter("idCategoria")));
			p.setCategoria(c);
			p.setPortada(request.getParameter("portada"));
			pl.addPelicula(p);
			LinkedList<Pelicula> peliculas = pl.getAll();
			request.setAttribute("peliculas", peliculas);
			request.getRequestDispatcher("MenuPeliculas.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}

	}
}
