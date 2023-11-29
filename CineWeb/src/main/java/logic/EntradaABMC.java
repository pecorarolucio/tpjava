package logic;

import java.util.LinkedList;

import data.DataEntrada;
import entities.Entrada;
import entities.Funcion;

public class EntradaABMC {
	private DataEntrada de;
	
	public EntradaABMC(){
		de = new DataEntrada();
	}
	
	public LinkedList<Entrada> findFromUser(int nrousuario) {
		return de.findFromUser(nrousuario);
	}
	
	public LinkedList<Entrada>findFromFuncion(Funcion f){
		return de.findFromFuncion(f);
	}
	
	public Entrada findOne(int cod) {
		return de.findOne(cod);
	}
	
	public void add(Entrada e) {
		de.add(e);
	}
	
	public void delete(Entrada e) {
		de.delete(e);
	}

}
