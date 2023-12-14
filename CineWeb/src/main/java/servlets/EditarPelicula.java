package servlets;

import java.io.File;
import java.io.IOException;
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
 * Servlet implementation class EditarPelicula
 */
@WebServlet("/Admin/Peliculas/EditarPelicula")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)
public class EditarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "upload";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula pel = new Pelicula();
		PeliculaABMC pl = new PeliculaABMC();
		LinkedList<Categoria> categorias = new LinkedList<>();
		CategoriaABMC cl = new CategoriaABMC();
		try {
			pel.setIdPelicula(Integer.parseInt(request.getParameter("idPelicula")));
			pel = pl.getOne(pel);
			categorias = cl.getAll();
			request.setAttribute("categorias", categorias);
			request.setAttribute("editPel", pel);
			request.getRequestDispatcher("editarPelicula.jsp").forward(request, response);
		} catch(SQLException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula pel = new Pelicula();
		LinkedList<Pelicula> pelis = new LinkedList<>();
		PeliculaABMC pl = new PeliculaABMC();
		try {
			pel.setIdPelicula(Integer.parseInt(request.getParameter("idPelicula")));
			pel = pl.getOne(pel);
			pel.setNombrePelicula(request.getParameter("nombre"));
			//IMAGEN//
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
				pel.setPortada(UPLOAD_DIR+File.separator+fileName);
			pl.updatePelicula(pel);
			response.sendRedirect("MenuPelicula");
		} catch(SQLException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("Error.jsp").forward(request, response);
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
