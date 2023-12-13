package logic;

import java.sql.SQLException;
import java.util.LinkedList;
//import java.util.Scanner;

import data.*;
import entities.*;

public class SalaABMC {
	private DataSala ds;
	
	public SalaABMC () {
		ds = new DataSala();
	}

	public LinkedList<Sala> getAll()  throws SQLException {
		return ds.getAll();
		
	}

	public void addSala(Sala sala) throws SQLException {
		ds.add(sala);
	}
	
	public void updateSala(Sala sala) throws SQLException {
		ds.update(sala);
	}
	
	public Sala searchSala(Sala sala) throws SQLException {
		return ds.search(sala);
	}
	
	public void deleteSala(Sala sala) throws SQLException {
		ds.delete(sala);
	}
	
}
