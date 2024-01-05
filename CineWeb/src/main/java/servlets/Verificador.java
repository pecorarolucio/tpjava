package servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
import entities.*;
/**
 * Servlet implementation class Verificador
 */

@WebServlet("/Verificador")
public class Verificador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verificador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	} */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String correo = request.getParameter("Loginnombre");
	    String contraseña = request.getParameter("Contrasenia");
	    Persona p = new Persona();
	    p.setMail(correo);
	    p.setContraseña(contraseña);
	    PersonaABMC pABMC = new PersonaABMC();
	    try {
		    Persona pers = pABMC.getOne(p);
		    if (pers != null) {
		    	 if ((correo == null || correo.isEmpty() ) || (contraseña == null || contraseña.isEmpty())) {
		 	        //response.getWriter().write("Completa todos los campos requeridos");
		 	        //return;
		 	    	 
		 	    	request.getRequestDispatcher("ErrorLogin.jsp").forward(request, response);
		 	    	 try {
		 				Class.forName("com.mysql.cj.jdbc.Driver");
		 			} catch (ClassNotFoundException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 			}
		 	    	 }
		 	    else {
		 	    request.getSession().setAttribute("usuario", pers);
		 		request.getRequestDispatcher("Index.jsp").forward(request, response);
		 	    };
		    }
		    else {
		    	request.getRequestDispatcher("ErrorLogin.jsp").forward(request, response);
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
		//doGet(request, response);


	}};
