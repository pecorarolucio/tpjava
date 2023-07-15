package entities;

public class Sala {
	private  int idSala;
	private int capacidadMaxima;
	
	
	
	
	
	
	
	
	public Sala(int idSala, int capacidadMaxima) {
		this.idSala = idSala;
		this.capacidadMaxima = capacidadMaxima;
	}
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	

}
