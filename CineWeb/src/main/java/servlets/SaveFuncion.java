package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Sala;
import logic.SalaABMC;

/**
 * Servlet implementation class SaveFuncion
 */
@WebServlet("/Admin/Funciones/SaveFuncion")
public class SaveFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveFuncion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String idPeli = request.getParameter("idPelicula");
				String Fecha = request.getParameter("Fecha");
				String HoraInicio = request.getParameter("HoraInicio");
				String IDSala = request.getParameter("IDSala");
				HttpSession user = request.getSession();
				user.setAttribute("peli", idPeli);
				user.setAttribute("fecha", Fecha);
				user.setAttribute("horainicio", HoraInicio);
				user.setAttribute("idsala", IDSala);
				SalaABMC sl = new SalaABMC();
				try {
					LinkedList<Sala> listSala = sl.getAll();
					request.setAttribute("salas", listSala);
					request.getRequestDispatcher("/Admin/Funciones/editarFuncion.jsp").forward(request, response);
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
