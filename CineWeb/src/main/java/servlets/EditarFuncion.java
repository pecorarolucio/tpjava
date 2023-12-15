package servlets;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.*;
import logic.*;
/**
 * Servlet implementation class EditarFuncion
 */
@WebServlet("/Admin/Funciones/EditarFuncion")
public class EditarFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarFuncion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession user = request.getSession();
		Funcion fAntiguo = new Funcion();
		fAntiguo.setFechaFuncion(LocalDate.parse((String) user.getAttribute("fecha")));
		fAntiguo.setHoraInicio(LocalTime.parse((String) user.getAttribute("horainicio")));
		fAntiguo.setSala(new Sala());
		fAntiguo.getSala().setIdSala(Integer.parseInt((String) user.getAttribute("idsala")));
		Funcion f = new Funcion();
		f.setFechaFuncion(LocalDate.parse(request.getParameter("fecha")));
		f.setHoraInicio(LocalTime.parse(request.getParameter("Hora_Inicio")));
		f.setHoraFin(LocalTime.parse(request.getParameter("Hora_Fin")));
		f.setPelicula(new Pelicula());
		f.getPelicula().setIdPelicula(Integer.parseInt((String)user.getAttribute("peli")));
		f.setSala(new Sala());
		f.getSala().setIdSala(Integer.parseInt(request.getParameter("idSala")));
		FuncionABMC fl = new FuncionABMC();
		PeliculaABMC pf = new PeliculaABMC();
		try {
			if(fAntiguo.getFechaFuncion()==f.getFechaFuncion() && fAntiguo.getHoraInicio()==f.getHoraInicio() && fAntiguo.getSala().getIdSala()==f.getSala().getIdSala() ) {
				fl.update(f, fAntiguo);	
			}
			else {
				if(fl.getOne(f) == null) {
					fl.update(f, fAntiguo);	
				}else {
					throw new SQLException("Ya existe una funcion a esta hora");
				}
			}
			response.sendRedirect("MenuFunciones");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

}
