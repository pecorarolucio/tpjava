package logic;

import entities.AppException;
import entities.Entrada;
import entities.Funcion;
import entities.Persona;

public class CompraEntradaController {
	
	
	public Entrada comprarEntrada(Funcion f, Persona p) throws AppException {
		FuncionABMC fl = new FuncionABMC();
		EntradaABMC el = new EntradaABMC();
		try {
			f=fl.getOne(f);
			if (!fl.isFull(f)) {
				Entrada e = new Entrada();
				e.setFuncion(f);
				e.setPersona(p);
				el.add(e);
				return e;
			} else {
				return null;
			}
		} catch(Exception e) {
			throw new AppException("Ha ocurrido un error inesperado");
		}
	}
}
