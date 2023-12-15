package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
import entities.*;
/**
 * Servlet implementation class EliminarFuncion
 */
@WebServlet("/Admin/Funciones/EliminarFuncion")
public class EliminarFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarFuncion() {
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
		// TODO Auto-generated method stub
		FuncionABMC fl = new FuncionABMC();
		Funcion f = new Funcion();
		PeliculaABMC pf = new PeliculaABMC();
		f.setFechaFuncion(LocalDate.parse(request.getParameter("Fecha")));
		f.setHoraInicio(LocalTime.parse(request.getParameter("HoraInicio")));
		f.setSala(new Sala());
		f.getSala().setIdSala(Integer.parseInt(request.getParameter("IDSala")));
		
		try {
			fl.deleteFuncion(f);
			request.setAttribute("peliculas", pf.getAll());
			request.getRequestDispatcher("/Admin/Funciones/MenuFunciones.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
		}
	}

}
