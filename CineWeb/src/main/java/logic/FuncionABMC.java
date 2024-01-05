package logic;

import java.sql.SQLException;
import java.util.LinkedList;

import data.DataFuncion;
import entities.AppException;
import entities.Funcion;
import entities.Pelicula;

public class FuncionABMC {
	
	private DataFuncion df;
	private EntradaABMC el;
	
	public FuncionABMC() {
		df = new DataFuncion();
		el = new EntradaABMC();
	}

	public void addFuncion(Funcion f)throws SQLException, AppException {
		df.add(f);
	}
	
	public LinkedList<Funcion> getFunciones(Pelicula p) throws SQLException, AppException{
		return df.getFunciones(p);
	}
	
	public void deleteFuncion(Funcion f)throws SQLException, AppException {
		df.delete(f);
	}
	
	public Funcion getOne(Funcion f)throws SQLException, AppException {
		return df.findOne(f);
	}
	
	public boolean isFull(Funcion f)throws SQLException, AppException {
		System.out.println(el.findFromFuncion(f).size()==f.getSala().getCapacidadMaxima());
		System.out.println(f.getSala().getCapacidadMaxima());
		return el.findFromFuncion(f).size()==f.getSala().getCapacidadMaxima();
		
	}
	public void update(Funcion f,Funcion fAnt) throws SQLException, AppException {
		df.update(f,fAnt);
	}
	
}
