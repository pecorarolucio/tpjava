package entities;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;


public class Funcion {
	
	//final private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate fechaFuncion;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private Sala sala;
	private Pelicula pelicula;
	
	
	
	public Funcion(LocalDate fechaFuncion, LocalTime horaInicio, LocalTime horaFin, Sala sala, Pelicula pelicula) {
		this.fechaFuncion = fechaFuncion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.sala = sala;
		this.pelicula = pelicula;
	}
	public LocalDate getFechaFuncion() {
		return fechaFuncion;
	}
	public void setFechaFuncion(LocalDate fechaFuncion) {
		this.fechaFuncion = fechaFuncion;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	
	
}
