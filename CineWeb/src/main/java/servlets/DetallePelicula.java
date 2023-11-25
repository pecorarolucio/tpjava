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
import logic.PersonaABMC;
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
		System.out.print("HOLAS2");
		PeliculaABMC pl = new PeliculaABMC();
		ReseñaABMC rl = new ReseñaABMC();
		
		
		if (idParam != null && !idParam.isEmpty()) {
			try {
				int idPelicula = Integer.parseInt(idParam);
				Pelicula pel = pl.getOne(idPelicula);		
				PersonaABMC p = new PersonaABMC();
				LinkedList<Reseña> reseñas = rl.getByPelicula(pel);
				for (Reseña r: reseñas) {
					r.getAutor().setNombre(p.getById(r.getAutor().getId()).getNombre());
				};
				
				System.out.print(pel.getIdPelicula());
				request.setAttribute("pelicula", pel);
				request.setAttribute("reseñas", reseñas);
				request.getRequestDispatcher("/DetallePelicula.jsp").forward(request, response);
			} catch(NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "id invalido");
			}
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "id requerido");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.print("HOLAS");
	}

}
