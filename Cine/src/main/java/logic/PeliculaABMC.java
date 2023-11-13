package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class PeliculaABMC {
	
	private DataPelicula dp;

	
	public PeliculaABMC () {
		dp = new DataPelicula();
	}

	/*public LinkedList<Pelicula> getAll() {
		return dp.getAll();
	}*/
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
	
	public LinkedList<Funcion> getFunciones(String p){
		return dp.getFunciones(p);
	}
}

