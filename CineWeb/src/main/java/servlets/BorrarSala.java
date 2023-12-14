package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Sala;
import logic.SalaABMC;
import java.util.LinkedList;
/**
 * Servlet implementation class BorrarSala
 */
@WebServlet("/Admin/Salas/BorrarSala")
public class BorrarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarSala() {
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
		SalaABMC sl = new SalaABMC();
		s.setIdSala(Integer.parseInt(request.getParameter("idSala")));
		try {
			s = sl.searchSala(s);
			sl.deleteSala(s);
			LinkedList<Sala> salas = new LinkedList<Sala>();
			request.setAttribute("salas", salas);
			request.getRequestDispatcher("MenuSalas.jsp").forward(request, response);
			
		} catch (SQLException e) {
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
		
	}

}
