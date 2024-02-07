package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.AppException;
import entities.Persona;
import logic.PersonaABMC;

/**
 * Servlet implementation class SignIn
 */
@WebServlet({ "/SignIn", "/signin", "/Signin", "/signIn" })
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		Persona p = new Persona();
		PersonaABMC lp = new PersonaABMC();
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setMail(correo);
		p.setContraseña(password);
		p.setTipo("Cliente");
		try {
			if (lp.findByMail(p) == null) {
				if (correo.isEmpty() || password.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
					response.getWriter().write("{\"error\": \"Todos los campos son requeridos\"}");
				}
				lp.addPersona(p);
				response.sendRedirect("login.html");
			} else {
				response.getWriter().write("{\"error\" \"Ya existe una cuenta registrada a ese mail\"}");
			}
		} catch(SQLException e) {
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp");
		} catch (AppException e) {
			request.setAttribute("error", "Hubo un error inesperado");
			request.setAttribute("causa", e.getMessage().toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

}
