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
	
	public LinkedList<Persona> getAll() throws SQLException{
		return dp.getAll();
	};
	
	public Persona getOne(Persona p) throws SQLException {
		return dp.getOne(p);
	};
	
	public void addPersona(Persona p)throws SQLException {
		dp.add(p);
	};
	
	public void updatePersona(Persona p) throws SQLException{
		dp.update(p);
	};
	
	public void deletePersona(Persona p) throws SQLException {
		dp.delete(p);
	};
	
	public Persona findByMail(Persona p) throws SQLException {
		return dp.findByMail(p);
	}
	
	public Persona getById(int id)throws SQLException {
		return dp.getByID(id);
	}
	
	
}
