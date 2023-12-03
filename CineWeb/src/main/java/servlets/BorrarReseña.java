package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Reseña;
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
		r.setCodigo(Integer.parseInt(request.getParameter("idReseña")));
		rl.deleteReseña(r);
	}

}
