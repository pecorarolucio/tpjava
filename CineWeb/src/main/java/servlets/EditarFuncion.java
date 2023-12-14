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
@WebServlet("/EditarFuncion")
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
			fl.deleteFuncion(fAntiguo);
			fl.addFuncion(f);
			request.setAttribute("peliculas", pf.getAll());
			request.getRequestDispatcher("/Admin/Funciones/MenuFunciones.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}

}
