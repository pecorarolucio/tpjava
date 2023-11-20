package logic;

import java.util.LinkedList;

import data.DataReseña;
import entities.Pelicula;
import entities.Reseña;

public class ReseñaABMC {
	
	private DataReseña dr;
	
	public ReseñaABMC() {
		dr = new DataReseña();
	}
	
	public LinkedList<Reseña> getByPelicula(Pelicula p) {
		return dr.getReseñas(p);
	}
}
