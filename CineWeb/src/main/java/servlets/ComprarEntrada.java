package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Entrada;
import entities.Funcion;
import entities.Persona;
import entities.Sala;
import logic.EntradaABMC;
import logic.FuncionABMC;

/**
 * Servlet implementation class ComprarEntrada
 */
@WebServlet("/ComprarEntrada")
public class ComprarEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarEntrada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Persona per = (Persona)  session.getAttribute("usuario");
		if (per!=null) {
			LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
			LocalTime horaInicio = LocalTime.parse(request.getParameter("hora"));
			int idSala = Integer.parseInt(request.getParameter("idSala"));
			Sala s = new Sala();
			s.setIdSala(idSala);
			FuncionABMC fl = new FuncionABMC();
			Funcion f = new Funcion();
			f.setFechaFuncion(fecha);
			f.setHoraInicio(horaInicio);
			f.setSala(s);
			f = fl.getOne(f);
			if (!fl.isFull(f)) {
				EntradaABMC el = new EntradaABMC();
				Entrada e = new Entrada();
				e.setFuncion(f);
				e.setPersona(per);
				el.add(e);
				//AGREGAR QUE REDIRIJA A UNA PAGINA DE EXITO
			} else {
				//AGREGAR QUE REDIRIJA A UNA PAGINA DE ERROR DE SALA LLENA
			}
		} else {
			response.sendRedirect(request.getContextPath() + "login.html");
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
