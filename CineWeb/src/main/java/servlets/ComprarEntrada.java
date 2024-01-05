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
import javax.servlet.http.HttpSession;

import entities.AppException;
import entities.Entrada;
import entities.Funcion;
import entities.Persona;
import entities.Sala;
import logic.CompraEntradaController;
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
		try {
			Persona p = (Persona)request.getSession().getAttribute("usuario");	
			if (p!=null) {
				LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
				LocalTime horaInicio = LocalTime.parse(request.getParameter("hora"));
				int idSala = Integer.parseInt(request.getParameter("idSala"));
				Sala s = new Sala();
				s.setIdSala(idSala);
				CompraEntradaController cec = new CompraEntradaController();
				Funcion f = new Funcion();
				f.setFechaFuncion(fecha);
				f.setHoraInicio(horaInicio);
				f.setSala(s);
				Entrada e = cec.comprarEntrada(f, p);
				if (e!=null) {
				/*if (!fl.isFull(f)) {
					EntradaABMC el = new EntradaABMC();
					Entrada e = new Entrada();
					e.setFuncion(f);
					e.setPersona(p);
					el.add(e);*/
					//AGREGAR QUE REDIRIJA A UNA PAGINA DE EXITO
					//request.setAttribute("EstadoCompra", resultado);
					//request.getRequestDispatcher("EXITO.jsp").forward(request, response);
					response.sendRedirect("Exito.jsp");
				} else if(e==null) {
					String resultado = "fallido";
					//AGREGAR QUE REDIRIJA A UNA PAGINA DE ERROR DE SALA LLENA
					request.setAttribute("EstadoCompra", resultado);
					request.getRequestDispatcher("SALALLENA.jsp").forward(request, response);
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login.html");
			}
		} catch(SQLException e) {
			request.setAttribute("error", e);
			request.setAttribute("causa",  e.toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		} catch(AppException e) {
			request.setAttribute("error", e);
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
	}
		// TODO Auto-generated method stub
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
