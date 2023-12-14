package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import entities.Categoria;
import entities.Pelicula;
import logic.CategoriaABMC;
import logic.PeliculaABMC;

/**
 * Servlet implementation class AgregarPelicula
 */
@WebServlet({ "/Admin/Peliculas/AgregarPelicula" })
@MultipartConfig
public class AgregarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula p = new Pelicula();
		Categoria c = new Categoria();
		CategoriaABMC cl = new CategoriaABMC();
		PeliculaABMC pl = new PeliculaABMC();
		try {
			p.setNombrePelicula(request.getParameter("nombre"));
			c = cl.getOne(Integer.parseInt(request.getParameter("idCategoria")));
			Part filePart = request.getPart("portada");
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			String relativePath = "/image/" + fileName;
			String absolutePath = getServletContext().getRealPath(relativePath);
			//InputStream stream = getServletContext().getResourceAsStream("/image/c2.jpg");

			//p.setPortada(stream.toString);
			//String path = getServletContext().getRealPath("/"+"image"+ File.separator+fileName);
			filePart.write(absolutePath);
			//InputStream is = filePart.getInputStream();
			
			//uploadFile(is, path);
			p.setPortada(relativePath);
			System.out.println(relativePath);
			System.out.println(p.getPortada());
			p.setCategoria(c);
			LinkedList<Pelicula> peliculas = pl.getAll();
			pl.addPelicula(p);
			response.sendRedirect("MenuPelicula");
		} catch(SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			System.out.println(e.getCause());
		}

	}
	
	public void uploadFile(InputStream is, String path) {
	    try {
	        byte[] buffer = new byte[is.available()];
	        int bytesRead;

	        try (FileOutputStream fops = new FileOutputStream(path)) {
	            while ((bytesRead = is.read(buffer)) != -1) {
	                fops.write(buffer, 0, bytesRead);
	            }
	            fops.flush();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}


