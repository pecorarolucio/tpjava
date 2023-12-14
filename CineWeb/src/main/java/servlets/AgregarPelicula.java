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

import entities.Categoria;
import entities.Pelicula;
import logic.CategoriaABMC;
import logic.PeliculaABMC;

/**
 * Servlet implementation class AgregarPelicula
 */
@WebServlet({ "/Admin/Peliculas/AgregarPelicula" })
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)
public class AgregarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "upload";
       
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
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula p = new Pelicula();
		Categoria c = new Categoria();
		CategoriaABMC cl = new CategoriaABMC();
		PeliculaABMC pl = new PeliculaABMC();
		try {
			p.setNombrePelicula(request.getParameter("nombre"));
			c = cl.getOne(Integer.parseInt(request.getParameter("idCategoria")));
			//Part filePart = request.getPart("portada");
	        String applicationPath = request.getServletContext().getRealPath("");
	        // constructs path of the directory to save uploaded file
	        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	        
	        File fileSaveDir = new File(uploadFilePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	        
	        String fileName = null;
	        //Get all the parts from request and write it to the file on server
	        for (Part part : request.getParts()) {
	        	if (part.getSubmittedFileName() != null) {
		            fileName = getFileName(part);
		            part.write(uploadFilePath + File.separator + fileName);
	        	}
	        }
			p.setPortada(UPLOAD_DIR+File.separator+fileName);
			System.out.println(p.getPortada());
			LinkedList<Pelicula> peliculas = pl.getAll();
			request.setAttribute("peliculas", peliculas);
			p.setCategoria(c);
			pl.addPelicula(p);
			response.sendRedirect("MenuPelicula");
		} catch(SQLException e) {
			request.setAttribute("error", e.getMessage());
			request.setAttribute("causa", e.getCause());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}

	}
	
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}


