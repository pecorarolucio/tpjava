package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.DataFuncion;
import entities.*;

/**
 * Servlet implementation class ListaFunciones
 */
@WebServlet("/ListaFunciones")
public class ListaFunciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaFunciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Persona p = (Persona) request.getSession().getAttribute("usuario");
		if(p == null) {
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
		else {
		DataFuncion dtFunc = new DataFuncion();
		Pelicula pel = new Pelicula();
		int idPelicula = Integer.parseInt(request.getParameter("IdPelicula"));
		pel.setIdPelicula(idPelicula);
		try {
			LinkedList<Funcion> listafunciones = dtFunc.getFunciones(pel);
			request.setAttribute("funciones", listafunciones);
			request.getRequestDispatcher("ListadeFuncionesxPelicula.jsp").forward(request, response);
		}	catch(SQLException e) {
				request.setAttribute("error", "Se ha producido un error en la base de datos");
				request.setAttribute("causa", e.toString());
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
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
