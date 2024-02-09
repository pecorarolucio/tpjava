package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import logic.*;
import entities.*;
/**
 * Servlet implementation class CancelarTickets
 */
@WebServlet("/CancelarTickets")
public class CancelarTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarTickets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigoEntrada = Integer.parseInt(request.getParameter("entradaId"));
		EntradaABMC miE = new EntradaABMC();
		Entrada ent = new Entrada();
		try {
			ent = miE.cancelarEntrada(codigoEntrada);
			if (ent!=null) {
				response.sendRedirect("ExitoCancelacion.jsp");
			} else {
				throw new AppException("Entrada inexistente");
			}
		}
		catch (AppException e) {
			request.setAttribute("error", e);
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		} catch(SQLException e) {
				request.setAttribute("error", "Se ha producido un error en la base de datos");
				request.setAttribute("causa", e.toString());
				request.getRequestDispatcher("/Error.jsp").forward(request, response);;
		}
		
	}
	
}
