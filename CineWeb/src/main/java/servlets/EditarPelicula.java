package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import logic.PeliculaABMC;

/**
 * Servlet implementation class EditarPelicula
 */
@WebServlet({ "/EditarPelicula", "/editarPelicula", "/Editarpelicula" })
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
		request.setAttribute("editPel", pel);
		request.getRequestDispatcher("EditarPelicula.jsp").forward(request, response);
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
		response.sendRedirect("MenuPeliculas.jsp");
	}

}
