package servlets;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PeliculaABMC;
import logic.CategoriaABMC;
import logic.FuncionABMC;
import entities.Categoria;
import entities.Pelicula;

/**
 * Servlet implementation class BuscaPelixCat
 */
@WebServlet("/BuscaPelixCat")
public class BuscaPelixCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaPelixCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PeliculaABMC PelABMC = new PeliculaABMC();
		CategoriaABMC CatABMC = new CategoriaABMC();
		FuncionABMC funABMC = new FuncionABMC();
		Categoria cat = new Categoria();
		int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
		System.out.println("Datos recibidos: " + idcategoria);
		try {
			cat.setIdCategoria(idcategoria);
			LinkedList<Pelicula> listaPelisxCategoria =PelABMC.getPeliculasxCategoria(CatABMC.searchCategoria(cat));
			//REMUEVO LAS PELICULAS QUE NO TENGAN FUNCIONES FUTURAS, NO SE SI SERIA MEJOR QUE EN EL JSP SE VERIFIQUE SI TIENE FUNCIONES Y SINO QUE NO LO MUESTRE
			//for (Pelicula p:listaPelisxCategoria) {
			//	if(funABMC.getFunciones(p).size() == 0) {
			//		listaPelisxCategoria.remove(p);
			//	}
				
			//};
			Iterator<Pelicula> iterator = listaPelisxCategoria.iterator();
			while (iterator.hasNext()) {
			    Pelicula p = iterator.next();
			    if (funABMC.getFunciones(p).size() == 0) {
			        iterator.remove();
			    }
			}
			request.setAttribute("peliculas", listaPelisxCategoria);
			request.getRequestDispatcher("PelisxCat.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp").forward(request, response);
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
