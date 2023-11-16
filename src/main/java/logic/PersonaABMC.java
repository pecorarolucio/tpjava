package logic;

import data.*;
import entities.*;
import java.util.LinkedList;

public class PersonaABMC {
	private DataPersona dp;
	
	public PersonaABMC() {
		dp = new DataPersona();
	}
	
	public LinkedList<Persona> getAll(){
		return dp.getAll();
	};
	
	public Persona getOne(Persona p) {
		return dp.getOne(p);
	};
	
	public void addPersona(Persona p) {
		dp.add(p);
	};
	
	public void updatePersona(Persona p) {
		dp.update(p);
	};
	
	public void deletePersona(Persona p) {
		dp.delete(p);
	};
	
	
}
