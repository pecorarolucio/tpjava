package logic;

import java.util.LinkedList;
//import java.util.Scanner;

import data.*;
import entities.*;

public class SalaABMC {
	private DataSala ds;
	
	public SalaABMC () {
		ds = new DataSala();
	}

	public LinkedList<Sala> getAll() {
		return ds.getAll();
		
	}

	public void addSala(Sala sala) {
		ds.add(sala);
	}
	
	public void updateSala(Sala sala) {
		ds.update(sala);
	}
	
	public void deleteSala(Sala sala) {
		ds.delete(sala);
	}

	
	public Sala searchSala(Sala s) {
		return ds.search(s);
	}
}
