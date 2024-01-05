package logic;

import java.sql.SQLException;

import entities.AppException;
import entities.Entrada;
import entities.Funcion;
import entities.Persona;

public class CompraEntradaController {
	
	
	public Entrada comprarEntrada(Funcion f, Persona p) throws SQLException, AppException {
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
		} catch (SQLException e) {
			throw new SQLException("Ha ocurrido un error en la base de datos", e);
		} catch(AppException e) {
			throw new AppException("Ha ocurrido un error inesperado", e);
		}
	}
}
