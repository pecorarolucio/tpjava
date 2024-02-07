package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.AppException;
import entities.Persona;
import entities.Reseña;
import logic.PersonaABMC;
import logic.ReseñaABMC;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Cliente/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReseñaABMC rl = new ReseñaABMC();
		Persona p = (Persona) request.getSession().getAttribute("usuario");
		try {
			LinkedList<Reseña> reseñas = rl.getByUser(p);
			request.setAttribute("reseñas", reseñas);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", "Hubo un error en la base de datos");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		} catch (AppException e) {
			request.setAttribute("error", "Hubo un error inesperado");
			request.setAttribute("causa", e.getMessage().toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonaABMC pl = new PersonaABMC();
		Persona p = (Persona) request.getSession().getAttribute("usuario");
		p.setNombre(request.getParameter("nombre"));
		p.setApellido(request.getParameter("apellido"));
		p.setMail(request.getParameter("mail"));
		try {
			pl.updatePersona(p);
			response.sendRedirect("Profile");
		} catch(SQLException e) {
			request.setAttribute("error", "Ha ocurrido un error en la base de datos");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		} catch (AppException e) {
			request.setAttribute("error", "Hubo un error inesperado");
			request.setAttribute("causa", e.getMessage().toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
	}

}
