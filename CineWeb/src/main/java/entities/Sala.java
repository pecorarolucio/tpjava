package entities;

public class Sala {
	private  int id;
	private int capacidadMaxima;
	

	public Sala(int id, int capacidadMaxima) {
		this.id = id;
		this.capacidadMaxima = capacidadMaxima;
	}
	public Sala() {
		
	}
	public int getIdSala() {
		return id;
	}
	public void setIdSala(int id) {
		this.id = id;
	}
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	public String toString() {
		return "Sala [id=" + id + ", capacidadMaxima=" + capacidadMaxima + "]";
	}
	

}
