package servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.AppException;
import entities.Categoria;
import logic.*;
import java.util.LinkedList;

/**
 * Servlet implementation class Categoria
 */
@WebServlet("/BuscaCategorias")
public class BuscaCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoriaABMC categoriaABMC = new CategoriaABMC();
		try {
			LinkedList<Categoria> listaCategoria = categoriaABMC.getAll(); 
			request.setAttribute("Categorias", listaCategoria);
			
			request.getRequestDispatcher("ListaCategoria.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", "Se ha producido un error en la base de datos");
			request.setAttribute("causa", e.toString());
			request.getRequestDispatcher("/Error.jsp");
		} catch (AppException e) {
			request.setAttribute("error", "Hubo un error inesperado");
			request.setAttribute("causa", e.getMessage().toString());
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
