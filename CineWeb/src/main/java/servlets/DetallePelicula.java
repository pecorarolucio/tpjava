package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import entities.Reseña;
import logic.PeliculaABMC;
import logic.ReseñaABMC;

/**
 * Servlet implementation class DetallePelicula
 */
@WebServlet({ "/DetallePelicula", "/detallePelicula", "/Detallepelicula", "/detallepelicula" })
public class DetallePelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallePelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		
		if (idParam != null && !idParam.isEmpty()) {
			try {
				int idPelicula = Integer.parseInt(idParam);
				PeliculaABMC pl = new PeliculaABMC();
				Pelicula pel = pl.getOne(idPelicula);
				ReseñaABMC rl = new ReseñaABMC();
				LinkedList<Reseña> reseñas = rl.getByPelicula(pel);
				
				request.setAttribute("pelicula", pel);
				request.setAttribute("reseñas", reseñas);
				request.getRequestDispatcher("/DetallePelicula.jsp");
			} catch(NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "id invalido");
			}
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "id requerido");
		}
	}

}
