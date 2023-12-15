package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import entities.Sala;
import logic.SalaABMC;

/**
 * Servlet implementation class EditarSala
 */
@WebServlet({ "/Admin/Salas/EditarSala" })
public class EditarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarSala() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sala s = new Sala();
		SalaABMC sl = new SalaABMC();
		try {
			s.setIdSala(Integer.parseInt(request.getParameter("idSala")));
			s = sl.searchSala(s);
			request.setAttribute("sala", s);
			request.getRequestDispatcher("/Admin/Salas/editarSala.jsp").forward(request, response);
			
		} catch (SQLException e) {
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sala s = new Sala();
		SalaABMC sl = new SalaABMC();
		LinkedList<Sala> salas = new LinkedList<>();
		try {
			s.setIdSala(Integer.parseInt(request.getParameter("idSala")));
			s = sl.searchSala(s);
			s.setCapacidadMaxima(Integer.parseInt(request.getParameter("capacidad")));
			sl.updateSala(s);
			salas = sl.getAll();
			request.setAttribute("salas", salas);
			request.getRequestDispatcher("MenuSalas.jsp").forward(request, response);
			
		} catch (SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
		
	}

}
