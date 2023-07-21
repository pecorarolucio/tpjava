package entities;

public class Pelicula {
	private int idPelicula;
	private String nombrePelicula;
	private Categoria categoria;
	

	
	public Pelicula(int idPelicula, String nombrePelicula, Categoria categoria) {
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
		this.categoria = categoria;
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
	
	
	
	
	
}
