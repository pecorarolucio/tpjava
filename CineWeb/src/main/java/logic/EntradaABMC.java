package logic;

import java.sql.SQLException;
import java.util.LinkedList;

import data.DataEntrada;
import entities.Entrada;
import entities.Funcion;

public class EntradaABMC {
	private DataEntrada de;
	
	public EntradaABMC(){
		de = new DataEntrada();
	}
	
	public LinkedList<Entrada> findFromUser(int nrousuario) throws SQLException {
		return de.findFromUser(nrousuario);
	}
	
	public LinkedList<Entrada>findFromFuncion(Funcion f) throws SQLException{
		return de.findFromFuncion(f);
	}
	
	public Entrada findOne(int cod)throws SQLException {
		return de.findOne(cod);
	}
	
	public void add(Entrada e) throws SQLException {
		de.add(e);
	}
	
	public void delete(Entrada e) throws SQLException {
		de.delete(e);
	}

}
