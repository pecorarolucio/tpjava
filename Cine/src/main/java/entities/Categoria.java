package entities;

public class Categoria {
	private int id;
	private String nombre;
	
	
	
	public int getIdCategoria() {
		return id;
	}
	public void setIdCategoria(int id) {
		this.id = id;
	}
	public String getNombreCategoria() {
		return nombre;
	}
	public void setNombreCategoria(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public Categoria() {
	
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
