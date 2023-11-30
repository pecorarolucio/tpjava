package logic;

import java.util.LinkedList;

import data.DataReseña;
import entities.Pelicula;
import entities.Persona;
import entities.Reseña;

public class ReseñaABMC {
	
	private DataReseña dr;
	
	public ReseñaABMC() {
		dr = new DataReseña();
	}
	
	public LinkedList<Reseña> getByPelicula(Pelicula p) {
		return dr.getReseñas(p);
	}
	
	public LinkedList<Reseña> getByUser(Persona p){
		return dr.getReseñasFromUser(p);
	}
	
	public void addReseña(Reseña r) {
		dr.addReseña(r);
	}
	
	public void deleteReseña(Reseña r) {
		dr.deleteReseña(r);
	}
	
	public void updateReseña(Reseña r) {
		dr.updateReseña(r);
	}
}
