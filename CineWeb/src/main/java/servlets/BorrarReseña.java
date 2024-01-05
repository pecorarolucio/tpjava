package servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.AppException;
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
		request.setCharacterEncoding("UTF-8");
		System.out.println("ñ");
		Reseña r = new Reseña();
		ReseñaABMC rl = new ReseñaABMC();
		PeliculaABMC pl = new PeliculaABMC();
		Pelicula pel = new Pelicula();
		System.out.println(request.getParameter("codigo"));
		r.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		String referer = request.getHeader("Referer");
		if(referer!=null && !referer.contains("DetallePelicula")) {
			try {
				rl.deleteReseña(r);
				String encodedURL = URLEncoder.encode("MisReseñas", StandardCharsets.UTF_8);
				response.sendRedirect(encodedURL);//NO DICE MISRESEÑAS PORQUE HAY PROBLEMAS CON LA Ñ
			} catch(SQLException e) {
				request.setAttribute("error", "Se ha producido un error en la base de datos");
				request.setAttribute("causa", e.toString());
			} catch (AppException e) {
				request.setAttribute("error", "Hubo un error inesperado");
				request.setAttribute("causa", e.getMessage().toString());
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
		} else {
			try {

				pel.setIdPelicula(Integer.parseInt(request.getParameter("idPelicula")));
	
				rl.deleteReseña(r);
				pel=pl.getOne(pel);
				LinkedList<Reseña> reseñas = rl.getByPelicula(pel);
				request.setAttribute("pelicula", pel);
				request.setAttribute("reseñas", reseñas);
				request.getRequestDispatcher("DetallePelicula.jsp").forward(request, response);
			} catch(SQLException e) {
				request.setAttribute("error", "Se ha producido un error en la base de datos");
				request.setAttribute("causa", e.toString());
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			} catch (AppException e) {
				request.setAttribute("error", "Hubo un error inesperado");
				request.setAttribute("causa", e.getMessage().toString());
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
		}
	}

}
