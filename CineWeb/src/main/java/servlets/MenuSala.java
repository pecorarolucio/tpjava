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
import entities.Categoria;
import entities.Sala;
import logic.CategoriaABMC;
import logic.SalaABMC;

/**
 * Servlet implementation class Sala
 */
@WebServlet("/Admin/Salas/MenuSala")
public class MenuSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuSala() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String opc = request.getParameter("option");
		SalaABMC miSala = new SalaABMC();
		try {
			LinkedList<Sala> salas =miSala.getAll();
			request.setAttribute("salas", salas);
			request.getRequestDispatcher("/Admin/Salas/MenuSalas.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp");
		} catch (AppException e) {
			request.setAttribute("error", "Hubo un error inesperado");
			request.setAttribute("causa", e.getMessage().toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
		
		/*switch (opc) {
			case "add": 
				int capacidad = Integer.parseInt(request.getParameter("capacidad"));
				s.setCapacidadMaxima(capacidad);
				miSala.addSala(s);
				request.setAttribute("sala", s);
				request.getRequestDispatcher("agregarSala.jsp").forward(request, response);
			break;
			default:
				throw new AssertionError();
		}*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
