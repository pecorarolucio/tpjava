package entities;

public class Pelicula {
	private int idPelicula;
	private String nombrePelicula;
	private Categoria categoria;
	private String portada;
	

	
	public Pelicula(int idPelicula, String nombrePelicula, Categoria categoria, String portada) {
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
		this.categoria = categoria;
		this.portada = portada;
	}
	
	public Pelicula() {
		
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", nombrePelicula=" + nombrePelicula + ", categoria=" + categoria
				+ "]";
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getIdPelicula() {
		return idPelicula;
	}	
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getNombrePelicula() {
		return nombrePelicula;
	}
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
	
	public String getPortada() {
		return portada;
	}
	
	public void setPortada(String portada) {
		this.portada=portada;
	}
}
