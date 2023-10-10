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

	
	public LinkedList<Funcion> getFunciones(Pelicula p) {
		return df.getFunciones(p);
	}
}
