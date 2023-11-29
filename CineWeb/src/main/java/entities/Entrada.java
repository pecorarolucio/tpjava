package entities;



public class Entrada {
	private int codEntrada;
	private int precio;
	private Funcion funcion;
	private Persona persona;
	
	public Entrada(int codEntrada, int precio, Funcion funcion, Persona persona) {
		this.codEntrada=codEntrada;
		this.precio=precio;
		this.funcion=funcion;
		this.persona = persona;
	}
	
	public Entrada() {
	};
	
	public int getCodEntrada() {
		return codEntrada;
	}
	public void setCodEntrada(int codEntrada) {
		this.codEntrada=codEntrada;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio=precio;
	}
	
	public Funcion getFuncion() {
		return funcion;
	}
	
	public void setFuncion(Funcion funcion) {
		this.funcion=funcion;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona=persona;
	}
}