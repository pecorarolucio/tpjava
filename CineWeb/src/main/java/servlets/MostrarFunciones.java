package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
import entities.*;
import java.util.LinkedList;
/**
 * Servlet implementation class MostrarFunciones
 */
@WebServlet("/MostrarFunciones")
public class MostrarFunciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarFunciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		Pelicula p= new Pelicula();
		FuncionABMC fl = new FuncionABMC();
		p.setIdPelicula(idPelicula);
		try {
			LinkedList<Funcion> Listafunciones = fl.getFunciones(p);
			request.setAttribute("funciones", Listafunciones);
			request.setAttribute("pelicula", p);
			request.getRequestDispatcher("/Admin/Funciones/ListaFunciones.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
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
