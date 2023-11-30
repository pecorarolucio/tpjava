package data;

import java.sql.Date;
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
	
	public LinkedList<Reseña> getReseñasFromUser(Persona p){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Reseña> reseñas = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("Select r.codigo, r.descripcion, r.fecha, r.IDPelicula, pel.nombre from reseña r"
					+ "inner join pelicula pel on r.IDPelicula = pel.idpelicula where nrousuario = ?");
			stmt.setInt(1, p.getId());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Reseña r = new Reseña();
					r.setCodigo(rs.getInt("r.codigo"));
					r.setDescripcion(rs.getString("r.descripcion"));
					r.setFecha(rs.getDate("r.fecha").toLocalDate());
					Pelicula pel = new Pelicula();
					pel.setIdPelicula(rs.getInt("r.IDPelicula"));
					pel.setNombrePelicula(rs.getString("pel.nombre"));
					r.setPelicula(pel);
					r.setAutor(p);
					reseñas.add(r);
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return reseñas;
	}
	
	public void addReseña(Reseña r) {
		PreparedStatement stmt = null;
		ResultSet KeyResultSet = null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("Insert into reseña(descripcion, fecha, IDPelicula, nrousuario) values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, r.getDescripcion());
			stmt.setDate(2, Date.valueOf(r.getFecha()));
			stmt.setInt(3, r.getPelicula().getIdPelicula());
			stmt.setInt(4, r.getAutor().getId());
			stmt.executeUpdate();
			KeyResultSet = stmt.getGeneratedKeys();
			if(KeyResultSet!=null && KeyResultSet.next()) {
				r.setCodigo(KeyResultSet.getInt(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(KeyResultSet!=null) KeyResultSet.close();
				if(stmt!=null) stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteReseña(Reseña r) {
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from reseña where codigo = ?");
			stmt.setInt(1, r.getCodigo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateReseña(Reseña r) {
		PreparedStatement stmt=null;
		try {
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update reseña set descripcion = ? where codigo=?");
			stmt.setString(1, r.getDescripcion());
			stmt.setInt(2, r.getCodigo());
			stmt.executeUpdate();
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
