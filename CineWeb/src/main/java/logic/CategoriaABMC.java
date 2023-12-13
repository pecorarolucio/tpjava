package logic;

import java.sql.SQLException;
import java.util.LinkedList;
//import java.util.Scanner;

import data.*;
import entities.*;


public class CategoriaABMC {
	//Scanner s=null;
	private DataCategoria dc;
	//Categoria c = new Categoria();
	/*public void start() {
		s = new Scanner(System.in);
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();}*/
	
	
	public	CategoriaABMC() {
		dc = new DataCategoria();
	}
	
	public LinkedList<Categoria> getAll() throws SQLException {
		
		return dc.getAll();
			
	}
	

	public void addCategoria (Categoria c) throws SQLException {
		dc.add(c);
	}

	public void updateCategoria(Categoria c)throws SQLException {
		dc.update(c);
	}
	public Categoria searchCategoria(Categoria c)throws SQLException {
		return dc.search(c);
	}

	public void deleteCategoria(Categoria c)throws SQLException {
		dc.delete(c);
	}
	
	public Categoria getOne(int id)throws SQLException {
		return dc.findOne(id);
	}
	
	/*private void executeCommand(String command) {
		switch (command) {
		case "getall":
			getAll();
			break;
		case "add":
			addCategoria(c);
			break;
		case "update":
			updateCategoria(c);
			break;
		case "delete":
			deleteCategoria(c);
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("getall/t/listar todas las categorias");
		System.out.println("add/t/añadir una categoria");
		System.out.println("update/t/actualizar una categoria");
		System.out.println("search/t/buscar una categoria");
		System.out.println("delete/t/eliminar una categoria");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}*/
	

	

}
