package entities;

import java.time.LocalDate;

public class Reseña {
	private int codigo;
	private String descripcion;
	private LocalDate fecha;
	private Cliente autor;
	private Pelicula pelicula;
	
	public Reseña(int codigo, String descripcion, LocalDate fecha, Cliente autor, Pelicula pelicula) {
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.fecha=fecha;
		this.autor=autor;
		this.pelicula=pelicula;
	}
	
	public Reseña() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo=codigo;
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Cliente getAutor() {
		return autor;
	}
	public void setAutor(Cliente autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "Reseña [codigo=" + codigo + ", pelicula=" + pelicula.getNombrePelicula()+ ", autor=" +autor.getUsername()+ ", descripcion=" +descripcion+ "]";
	}
}
