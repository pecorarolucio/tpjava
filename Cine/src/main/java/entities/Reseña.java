package entities;

import java.time.LocalDate;

public class Reseña {
	private int codigo;
	private String descripcion;
	private LocalDate fecha;
	private Cliente autor;
	private Pelicula pelicula;
	
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
}
