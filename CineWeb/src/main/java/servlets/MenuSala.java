package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Categoria;
import entities.Sala;
import logic.CategoriaABMC;
import logic.SalaABMC;

/**
 * Servlet implementation class Sala
 */
@WebServlet({ "/MenuSala", "/menuSala", "/menusala", "/Menusala" })
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
		SalaABMC miSala = new SalaABMC();
		
		LinkedList<Sala> salas =miSala.getAll();
		request.setAttribute("salas", salas);
		request.getRequestDispatcher("MenuSalas.jsp").forward(request, response);
		/*
		switch (accion) {
			case "listar":
				salas = miSala.getAll();
				request.setAttribute("Salas", salas);
				request.getRequestDispatcher("MenuSalas.jsp").forward(request, response);
				break;
			
			case "add": 
				/* capacidad = Integer.parseInt(request.getParameter("capacidad"));
				s.setCapacidadMaxima(capacidad);
				miSala.addSala(s);
				request.setAttribute("sala", s);
				request.getRequestDispatcher("agregarSala.jsp").forward(request, response);
			default:
				throw new AssertionError();
				*/
		
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
