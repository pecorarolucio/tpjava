package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
import entities.Reseña;
import logic.ReseñaABMC;

/**
 * Servlet implementation class MisReseñas
 */
@WebServlet({ "/MisReseñas", "/misReseñas", "/Misreseñas", "/misreseñas" })
public class MisReseñas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MisReseñas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = (Persona)request.getSession().getAttribute("usuario");
		if (p!=null) {
			ReseñaABMC rl = new ReseñaABMC();
			LinkedList<Reseña> reseñas = rl.getByUser(p);
			request.setAttribute("reseñas", reseñas);
			request.getRequestDispatcher("/MisReseñas.jsp");
		} else {
			response.sendError(404, "Usuario no encontrado");
		}
	}

}
