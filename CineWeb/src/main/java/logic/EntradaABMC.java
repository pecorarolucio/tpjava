package logic;

import java.sql.SQLException;
import java.util.LinkedList;

import data.DataEntrada;
import entities.AppException;
import entities.Entrada;
import entities.Funcion;

public class EntradaABMC {
	private DataEntrada de;
	
	public EntradaABMC(){
		de = new DataEntrada();
	}
	
	public LinkedList<Entrada> findFromUser(int nrousuario) throws SQLException, AppException {
		return de.findFromUser(nrousuario);
	}
	
	public LinkedList<Entrada>findFromFuncion(Funcion f) throws SQLException, AppException{
		return de.findFromFuncion(f);
	}
	
	public Entrada findOne(int cod)throws SQLException, AppException {
		return de.findOne(cod);
	}
	
	public void add(Entrada e) throws SQLException, AppException {
		de.add(e);
	}
	public Entrada cancelarEntrada(int cod) throws SQLException, AppException {
		Entrada ent = null;
		try {
			ent = de.findOne(cod);
			if (ent!=null) {
				de.delete(ent);
				return ent;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new SQLException("Ha ocurrido un error en la base de datos", e);
		} catch (Exception e) {
			throw new AppException ("Ha ocurrido un error inespereado");
		}
	}

}
