package logic;

import java.sql.SQLException;
import java.util.LinkedList;

import data.*;
import entities.*;

public class PeliculaABMC {
	
	private DataPelicula dp;
	private ReseñaABMC rl;
	private FuncionABMC fl;

	
	public PeliculaABMC () {
		dp = new DataPelicula();
		rl = new ReseñaABMC();
	}

	/*public LinkedList<Pelicula> getAll() {
		return dp.getAll();
	}*/
	
	public Pelicula getOne(Pelicula p) throws SQLException, AppException {
		return dp.findOne(p);
	}
	
	public LinkedList<Reseña> getReseñas(Pelicula p) throws SQLException, AppException{
		return rl.getByPelicula(p);
	}
	
	public LinkedList<Pelicula> getPeliculasxCategoria(Categoria c) throws SQLException, AppException{
		return dp.getPeliculasxCategoria(c);
	}
	
	public void addPelicula(Pelicula p) throws SQLException, AppException {
		dp.add(p);
	}
	
	public void updatePelicula(Pelicula p)throws SQLException, AppException {
		dp.update(p);
	}

	public void deletePelicula(Pelicula p) throws SQLException, AppException {
		dp.delete(p);
	}
	
	public LinkedList<Pelicula> getAll() throws SQLException, AppException{
		return dp.getAll();
	}
	
	public LinkedList<Funcion> getFunciones(Pelicula p) throws SQLException, AppException{
		return fl.getFunciones(p);
	}
}

