package logic;

import java.util.LinkedList;

import data.DataFuncion;
import entities.Funcion;
import entities.Pelicula;

public class FuncionABMC {
	
	private DataFuncion df;
	private EntradaABMC el;
	
	public FuncionABMC() {
		df = new DataFuncion();
	}

	public void addFuncion(Funcion f) {
		df.add(f);
	}
	
	public LinkedList<Funcion> getFunciones(Pelicula p) {
		return df.getFunciones(p);
	}
	
	public void deleteFuncion(Funcion f) {
		df.delete(f);
	}
	
	public Funcion getOne(Funcion f) {
		return df.findOne(f);
	}
	
	public boolean isFull(Funcion f) {
		return el.findFromFuncion(f).size()==f.getSala().getCapacidadMaxima();
	}
	
}
