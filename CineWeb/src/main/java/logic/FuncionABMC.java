package logic;

import java.util.LinkedList;

import data.DataFuncion;
import entities.Funcion;
import entities.Pelicula;

public class FuncionABMC {
	
	private DataFuncion df;
	
	public FuncionABMC() {
		df = new DataFuncion();
	}

	public void addFuncion(Funcion f) {
		dp.add(f);
	}
	
	public LinkedList<Funcion> getFunciones(Pelicula p) {
		return df.getFunciones(p);
	}
	
	public void deleteFuncion(Funcion f) {
		df.delete(f);
	}
}
