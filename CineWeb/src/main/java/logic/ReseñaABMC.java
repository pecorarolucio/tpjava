package logic;

import java.sql.SQLException;
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
	
	public LinkedList<Reseña> getByPelicula(Pelicula p) throws SQLException {
		return dr.getReseñas(p);
	}
	
	public LinkedList<Reseña> getByUser(Persona p)throws SQLException {
		return dr.getReseñasFromUser(p);
	}
	
	public void addReseña(Reseña r) throws SQLException {
		dr.addReseña(r);
	}
	
	public void deleteReseña(Reseña r) throws SQLException {
		dr.deleteReseña(r);
	}
	
	public void updateReseña(Reseña r) throws SQLException {
		dr.updateReseña(r);
	}
}
