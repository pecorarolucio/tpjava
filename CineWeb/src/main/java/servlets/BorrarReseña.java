package servlets;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class BorrarReseña
 */
@WebServlet({ "/BorrarReseña", "/borrarReseña", "/Borrarreseña", "/borrarreseña" })
public class BorrarReseña extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarReseña() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reseña r = new Reseña();
		ReseñaABMC rl = new ReseñaABMC();
		PeliculaABMC pl = new PeliculaABMC();
		Pelicula pel = new Pelicula();
		try {
			System.out.println("-------------------------------");
			System.out.println(request.getParameter("idReseña"));
			System.out.println("-------------------------------");
			pel.setIdPelicula(Integer.parseInt(request.getParameter("idPelicula")));
			r.setCodigo(Integer.parseInt(request.getParameter("idReseña")));
			rl.deleteReseña(r);
			pel=pl.getOne(pel);
			LinkedList<Reseña> reseñas = rl.getByPelicula(pel);
			request.setAttribute("pelicula", pel);
			request.setAttribute("reseñas", reseñas);
			request.getRequestDispatcher("DetallePelicula.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp");
		}
	}

}
