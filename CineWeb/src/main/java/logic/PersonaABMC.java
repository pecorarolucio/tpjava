package logic;

import data.*;
import entities.*;

import java.sql.SQLException;
import java.util.LinkedList;

public class PersonaABMC {
	private DataPersona dp;
	
	public PersonaABMC() {
		dp = new DataPersona();
	}
	
	public LinkedList<Persona> getAll() throws SQLException, AppException{
		return dp.getAll();
	};
	
	public LinkedList<Persona> getClientes() throws SQLException, AppException{
		return dp.getClientes();
	};
	
	public Persona getOne(Persona p) throws SQLException, AppException {
		return dp.getOne(p);
	};
	
	public void addPersona(Persona p)throws SQLException, AppException {
		dp.add(p);
	};
	
	public void updatePersona(Persona p) throws SQLException, AppException{
		dp.update(p);
	};
	
	public void deletePersona(Persona p) throws SQLException, AppException {
		dp.delete(p);
	};
	
	public Persona findByMail(Persona p) throws SQLException, AppException {
		return dp.findByMail(p);
	}
	
	public Persona getById(int id)throws SQLException, AppException {
		return dp.getByID(id);
	}
	
	
}
