package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Pelicula;
import entities.Persona;
import entities.Reseña;
import logic.PersonaABMC;

public class DataReseña {

	
	
	public LinkedList<Reseña> getReseñas(Pelicula p){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Reseña> reseñas = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT p.nombre, r.nrousuario, r.fecha, r.descripcion "+
					"FROM pelicula p "+
					"INNER JOIN reseña r ON p.idpelicula = r.idPelicula "+
					"WHERE p.idpelicula = ?");
			stmt.setInt(1, p.getIdPelicula());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while (rs.next()) {
					Reseña r = new Reseña();
					Persona per = new Persona();
				//	PersonaABMC pl = new PersonaABMC();
					per.setId(rs.getInt("r.nrousuario"));
				//	per.setNombre(pl.getById(per.getId()).getNombre());
					r.setAutor(per);//SOLO RECUPERO EL NRO DE USUARIO Y NOMBRE DEL AUTOR DE LA RESEÑA
					r.setDescripcion(rs.getString("r.descripcion"));
					r.setFecha(rs.getDate("r.fecha").toLocalDate());
					reseñas.add(r);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} finally {
		//	try {
		//		if(stmt!=null)stmt.close();
		//		DbConnector.getInstancia().releaseConn();
		//	}
		//	catch(SQLException e) {
		//		e.printStackTrace();
		//	}
			try {
			    if (rs != null) rs.close(); // Cerrar ResultSet
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			try {
			    if (stmt != null) stmt.close(); // Cerrar PreparedStatement
			    DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		}
		return reseñas;
	}
}
