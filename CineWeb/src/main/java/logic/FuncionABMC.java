package logic;

import java.sql.SQLException;
import java.util.LinkedList;

import data.DataFuncion;
import entities.Funcion;
import entities.Pelicula;

public class FuncionABMC {
	
	private DataFuncion df;
	private EntradaABMC el;
	
	public FuncionABMC() {
		df = new DataFuncion();
		el = new EntradaABMC();
	}

	public void addFuncion(Funcion f)throws SQLException {
		df.add(f);
	}
	
	public LinkedList<Funcion> getFunciones(Pelicula p) throws SQLException{
		return df.getFunciones(p);
	}
	
	public void deleteFuncion(Funcion f)throws SQLException {
		df.delete(f);
	}
	
	public Funcion getOne(Funcion f)throws SQLException {
		return df.findOne(f);
	}
	
	public boolean isFull(Funcion f)throws SQLException {
		return el.findFromFuncion(f).size()==f.getSala().getCapacidadMaxima();
		
	}
	public void update(Funcion f) throws SQLException {
		df.update(f);
	}
	
}
