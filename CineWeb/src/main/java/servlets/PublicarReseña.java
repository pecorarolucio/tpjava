package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.AppException;
import entities.Pelicula;
import entities.Persona;
import entities.Reseña;
import logic.PeliculaABMC;
import logic.ReseñaABMC;

/**
 * Servlet implementation class PublicarReseña
 */
@WebServlet({ "/PublicarReseña", "/publicarReseña", "/publicarreseña", "/Publicarreseña" })
public class PublicarReseña extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicarReseña() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = (Persona) request.getSession().getAttribute("usuario");
		if (p!=null) {
			int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
			PeliculaABMC pl = new PeliculaABMC();
			
			Pelicula pel = new Pelicula();
			pel.setIdPelicula(idPelicula);
			try {
				pel = pl.getOne(pel);
				if (pel!=null) {
					Reseña r = new Reseña();
					r.setAutor(p);
					r.setFecha(LocalDate.now());
					r.setPelicula(pel);
					r.setDescripcion(request.getParameter("descripcion"));
					ReseñaABMC rl = new ReseñaABMC();
					rl.addReseña(r);
					LinkedList<Reseña> reseñas = rl.getByPelicula(pel);
					request.setAttribute("pelicula", pel);
					request.setAttribute("reseñas", reseñas);
					request.getRequestDispatcher("DetallePelicula.jsp").forward(request, response);
				} else {
					response.sendError(404, "Pelicula no encontrada");
				}
			} catch(SQLException e) {
				request.setAttribute("error", e);
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			} catch (AppException e) {
				request.setAttribute("error", "Hubo un error inesperado");
				request.setAttribute("causa", e.getMessage().toString());
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/login.html");
		}
		
	}

}
