package logic;

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
	
	public Pelicula getOne(Pelicula p) {
		return dp.findOne(p);
	}
	
	public LinkedList<Reseña> getReseñas(Pelicula p){
		return rl.getByPelicula(p);
	}
	
	public LinkedList<Pelicula> getPeliculasxCategoria(Categoria c) {
		return dp.getPeliculasxCategoria(c);
	}
	
	public void addPelicula(Pelicula p) {
		dp.add(p);
	}
	
	public void updatePelicula(Pelicula p) {
		dp.update(p);
	}

	public void deletePelicula(Pelicula p) {
		dp.delete(p);
	}
	
	public LinkedList<Pelicula> getAll(){
		return dp.getAll();
	}
	
	public LinkedList<Funcion> getFunciones(Pelicula p){
		return fl.getFunciones(p);
	}
}

