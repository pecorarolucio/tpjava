package entities;

public class Categoria {
	private int idCategoria;
	private String nombreCategoria;
	
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	
	public Categoria(int idCategoria, String nombreCategoria) {
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
	}
	
	
	
	
}
