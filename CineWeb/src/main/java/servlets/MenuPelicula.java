package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import logic.PeliculaABMC;

/**
 * Servlet implementation class MenuPelicula
 */
@WebServlet({ "/Admin/Peliculas/MenuPelicula" })
public class MenuPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Pelicula> peliculas = new LinkedList<>();
		PeliculaABMC pl = new PeliculaABMC();
		try {
			peliculas = pl.getAll();
			request.setAttribute("peliculas", peliculas);
			request.getRequestDispatcher("/Admin/Peliculas/MenuPeliculas.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
	}

}
