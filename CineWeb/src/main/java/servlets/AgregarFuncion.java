package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.*;
import logic.*;
/**
 * Servlet implementation class AgregarFuncion
 */
@WebServlet("/Admin/Funciones/AgregarFuncion")
public class AgregarFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarFuncion() {
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
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		Funcion f = new Funcion();
		FuncionABMC fl = new FuncionABMC();
		PeliculaABMC pf = new PeliculaABMC();
		f.setFechaFuncion(LocalDate.parse(request.getParameter("fecha")));
		f.setHoraInicio(LocalTime.parse(request.getParameter("Hora_Inicio")));
		f.setHoraFin(LocalTime.parse(request.getParameter("Hora_Fin")));
		f.setPelicula(new Pelicula());
		f.getPelicula().setIdPelicula(idPelicula);
		f.setSala(new Sala());
		f.getSala().setIdSala(Integer.parseInt(request.getParameter("idSala")));
		try {
			if(fl.getOne(f) != null) {
				throw new SQLException("Ya existe una funcion a esta hora");
			}else {
				fl.addFuncion(f);	
			}
			request.setAttribute("peliculas", pf.getAll());
			request.getRequestDispatcher("/Admin/Funciones/MenuFunciones.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "Hubo un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		} catch (AppException e) {
			request.setAttribute("error", "Hubo un error inesperado");
			request.setAttribute("causa", e.getMessage().toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

}
