package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import entities.*;
import logic.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuFunciones
 */
@WebServlet("/MenuFunciones")
public class MenuFunciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuFunciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PeliculaABMC pl = new PeliculaABMC();
		try {
			LinkedList<Pelicula> listaPeli = pl.getAll();	
			request.setAttribute("peliculas", listaPeli);
			request.getRequestDispatcher("/Admin/Funciones/MenuFunciones.jsp").forward(request, response);
			
		} catch (SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
	
	}


}
