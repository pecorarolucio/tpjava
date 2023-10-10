package ui;

import java.util.Scanner;


import entities.*;
import logic.*;

public class menu {
	CategoriaABMC categoriaABMC = new CategoriaABMC();
	SalaABMC salaABMC = new SalaABMC();
	Scanner s=null;
	Categoria c = new Categoria();
	Sala sala = new Sala();
	PeliculaABMC peliculaABMC = new PeliculaABMC();
	Pelicula p = new Pelicula();
	Persona per = new Persona();
	ClienteABMC clienteABMC=new ClienteABMC();
	public void start() {
		s = new Scanner(System.in);
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
		}while(!command.equalsIgnoreCase("exit"));
		s.close();
	}
	
	private void executeCommand(String command) {
		int opc;
		switch (command) {
		case "list":
			System.out.print("Que desea listar? (1-Categorias/2-Salas/3-Peliculas x Categoria/4-Clientes): ");
			opc=Integer.parseInt(s.nextLine());
			if (opc == 1) {
			System.out.println(categoriaABMC.getAll());
			} else if (opc==2)  {System.out.println(salaABMC.getAll());
			} else if (opc==3){
				//Categoria cat = new Categoria();
				System.out.print("Ingrese id de categoria: ");
				c.setIdCategoria(Integer.parseInt(s.nextLine()));
				//cat = categoriaABMC.searchCategoria(c);
				System.out.print(peliculaABMC.getPeliculasxCategoria(categoriaABMC.searchCategoria(c)));
			}
			else if(opc==4) {
				System.out.println(clienteABMC.getAll());
			}
			else {
				System.out.println("Ingrese id de la pelicula a buscar sus funciones: ");
				p.setIdPelicula(Integer.parseInt(s.nextLine()));
				System.out.println(funcionABMC.getFunciones(p));
			}
			
			break;
		case "add":
			add();
			break;
		case "update":
			update();
			break;
		case "search":
			search();
			break;
		case "delete":
			delete();
			break;
		case "listSalas":
		default:
			break;
		}
	}

	private String getCommand() {
		
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list");
		System.out.println("add");
		System.out.println("update");
		System.out.println("delete");
		System.out.println("search");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private void search() {
		int op;
		System.out.println("Que desea consultar? (1-Pelicula/2-Categoria/3-Sala)");
		op=Integer.parseInt(s.nextLine());
		if (op==1) {
			System.out.println("Ingrese id de la pelicula");
			p.setIdPelicula(Integer.parseInt(s.nextLine()));
			System.out.println(peliculaABMC.searchPelicula(p));
		} else if (op==2) {
			System.out.println("Ingrese id de la categoria");
			c.setIdCategoria(Integer.parseInt(s.nextLine()));
			System.out.println(categoriaABMC.searchCategoria(c));
		} else if (op==3) {
			System.out.println("Ingrese id de la sala");
			sala.setIdSala(Integer.parseInt(s.nextLine()));
			System.out.println(salaABMC.searchSala(sala));
		}
		
	}
	private void add() {
		int opc2;
		System.out.print("Que desea añadir? (1-Categoria/2-Sala/3-Pelicula/4-Cliente): ");
		opc2=Integer.parseInt(s.nextLine());
		if(opc2 == 1) {
			System.out.print("Ingrese nombre de la categoria: ");
			c.setNombreCategoria(s.nextLine());
			categoriaABMC.addCategoria(c);
			} else if (opc2==2) {System.out.print("Ingrese capacidad maxima de la sala: ");
					sala.setCapacidadMaxima(Integer.parseInt(s.nextLine()));
					salaABMC.addSala(sala);}
			else if (opc2==3) {
				System.out.print("Ingrese id de la categoria: ");
				c.setIdCategoria(Integer.parseInt(s.nextLine()));
				System.out.print("Ingrese nombre de la pelicula: ");
				p.setNombrePelicula(s.nextLine());
				p.setCategoria(c);
				peliculaABMC.addPelicula(p);
			}
			else {
				System.out.print("Nombre: ");
				per.setNombre(s.nextLine());
				System.out.print("Apellido: ");
				per.setApellido(s.nextLine());
				System.out.print("Mail: ");
				per.setMail(s.nextLine());
				System.out.print("Contraseña: ");
				per.setContraseña(s.nextLine());
			}
	}
	
	private void update() {
		int opc; 
		System.out.print("Que desea modificar? (1-Categoria/2-Sala/3-Pelicula): ");
		opc=Integer.parseInt(s.nextLine());
		if (opc == 1) {
			System.out.print("Ingrese id de la categoria a modificar: ");
			c.setIdCategoria(Integer.parseInt(s.nextLine()));
			System.out.print("Actualice su nombre: ");
			c.setNombreCategoria(s.nextLine());
			categoriaABMC.updateCategoria(c);
			
		} else if(opc == 2) {
			System.out.print("Ingrese id de la sala a modificar: ");
			sala.setIdSala(Integer.parseInt(s.nextLine()));
			System.out.print("Actualice su capacidad maxima: ");
			sala.setCapacidadMaxima(Integer.parseInt(s.nextLine()));
			salaABMC.updateSala(sala);
		} else {
			System.out.print("Ingrese id de la pelicula a modificar: ");
			p.setIdPelicula(Integer.parseInt(s.nextLine()));
			System.out.print("Actualize id de categoria: ");
			c.setIdCategoria(Integer.parseInt(s.nextLine()));
			System.out.print("Actualice nombre de pelicula: ");
			p.setNombrePelicula(s.nextLine());
			p.setCategoria(c);
			peliculaABMC.updatePelicula(p);
		}
	}
	
	private void delete() {
		int opc; 
		System.out.print("Que desea borrar? (1-Categoria/2-Sala/3-Pelicula): ");
		opc=Integer.parseInt(s.nextLine());
		if (opc == 1) {
			System.out.print("Ingrese id de la categoria a borrar: ");
			c.setIdCategoria(Integer.parseInt(s.next()));
			System.out.print("Esta seguro de borrar esta categoria? (1-Si/0-No): ");
			opc=Integer.parseInt(s.next());
			if(opc==1) {
				categoriaABMC.deleteCategoria(c);
			}
		} else if (opc==2) {
			System.out.print("Ingrese id de la sala a borrar: ");
			sala.setIdSala(Integer.parseInt(s.nextLine()));
			System.out.print("Esta seguro de borrar esta sala? (1-Si/0-No): ");
			opc=Integer.parseInt(s.nextLine());
			if (opc==1) {
				salaABMC.deleteSala(sala);
			}
		} else {
			System.out.print("Ingrese id de la pelicula a borrar: ");
			p.setIdPelicula(Integer.parseInt(s.nextLine()));
			System.out.print("Esta seguro de borrar esta pelicula? (1-Si/0-No)");
			opc=Integer.parseInt(s.nextLine());
			if (opc == 1) {
				peliculaABMC.deletePelicula(p);
			}
		}
	}
	
}

