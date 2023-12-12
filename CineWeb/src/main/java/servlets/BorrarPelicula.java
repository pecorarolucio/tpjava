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
 * Servlet implementation class BorrarPelicula
 */
@WebServlet({ "/BorrarPelicula", "/borrarPelicula", "/Borrarpelicula", "/borrarpelicula" })
public class BorrarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula p = new Pelicula();
		p.setIdPelicula(Integer.parseInt(request.getParameter("idPelicula")));
		PeliculaABMC pl = new PeliculaABMC();
		pl.deletePelicula(p);
		response.sendRedirect("MenuPelicula.jsp");
	}

}
