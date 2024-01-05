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
import entities.Sala;
import logic.SalaABMC;

/**
 * Servlet implementation class AgregarSala
 */
@WebServlet({ "/Admin/Salas/AgregarSala" })
public class AgregarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarSala() {
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
		Sala s = new Sala();	
		SalaABMC salaAbmc = new SalaABMC();
		try {
			s.setCapacidadMaxima(Integer.parseInt(request.getParameter("capacidad")));
			salaAbmc.addSala(s);
			LinkedList<Sala> salas = salaAbmc.getAll();
			request.setAttribute("salas", salas);
			request.getRequestDispatcher("MenuSalas.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		} catch (AppException e) {
			request.setAttribute("error", "Hubo un error inesperado");
			request.setAttribute("causa", e.getMessage().toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

}
