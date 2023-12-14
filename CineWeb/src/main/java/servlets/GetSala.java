package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import entities.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;

/**
 * Servlet implementation class GetSala
 */
@WebServlet("/GetSala")
public class GetSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSala() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SalaABMC sl = new SalaABMC();
		try {
			String idPeli = request.getParameter("idPelicula");
			LinkedList<Sala> listSala = sl.getAll();
			request.setAttribute("salas", listSala);
			request.setAttribute("idpeli", idPeli);
			request.getRequestDispatcher("/Admin/Funciones/agregarFuncion.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
