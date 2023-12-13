package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Pelicula;
import entities.Persona;
import entities.Reseña;

public class DataReseña {

	
	
	public LinkedList<Reseña> getReseñas(Pelicula p) throws SQLException {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Reseña> reseñas = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT p.nombre, r.nrousuario, r.fecha, r.descripcion, r.codigo, us.nombre\r\n"
					+ "FROM pelicula p \r\n"
					+ "INNER JOIN reseña r ON p.idpelicula = r.idPelicula \r\n"
					+ "inner join usuario us on us.nrousuario = r.nrousuario\r\n"
					+ "WHERE p.idpelicula = ?;");
			stmt.setInt(1, p.getIdPelicula());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while (rs.next()) {
					Reseña r = new Reseña();
					Persona per = new Persona();
				//	PersonaABMC pl = new PersonaABMC();
					per.setId(rs.getInt("r.nrousuario"));
					per.setNombre(rs.getString("us.nombre"));
				//	per.setNombre(pl.getById(per.getId()).getNombre());
					r.setAutor(per);//SOLO RECUPERO EL NRO DE USUARIO Y NOMBRE DEL AUTOR DE LA RESEÑA
					r.setDescripcion(rs.getString("r.descripcion"));
					r.setFecha(rs.getDate("r.fecha").toLocalDate());
					r.setCodigo(rs.getInt("r.codigo"));
					r.setPelicula(p); //
					reseñas.add(r);
				}
			}
		}
		catch(SQLException e) {
			throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
		//	try {
		//		if(stmt!=null)stmt.close();
		//		DbConnector.getInstancia().releaseConn();
		//	}
		//	catch(SQLException e) {
		//		throw new SQLException("Hubo un error en la base de datos", e);
		//	}
			try {
			    if (rs != null) rs.close(); // Cerrar ResultSet
			} catch (SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
			try {
			    if (stmt != null) stmt.close(); // Cerrar PreparedStatement
			    DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
		return reseñas;
	}
	
	public LinkedList<Reseña> getReseñasFromUser(Persona p) throws SQLException {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Reseña> reseñas = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("Select r.codigo, r.descripcion, r.fecha, r.IDPelicula, pel.nombre from reseña r"
					+ " inner join pelicula pel on r.IDPelicula = pel.idpelicula where nrousuario = ?");
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
			throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
		return reseñas;
	}
	
	public void addReseña(Reseña r) throws SQLException {
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
			throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
			try {
				if(KeyResultSet!=null) KeyResultSet.close();
				if(stmt!=null) stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
	}
	
	public void deleteReseña(Reseña r) throws SQLException {
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from reseña where codigo = ?");
			stmt.setInt(1, r.getCodigo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
	}
	
	public void updateReseña(Reseña r) throws SQLException {
		PreparedStatement stmt=null;
		try {
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update reseña set descripcion = ? where codigo=?");
			stmt.setString(1, r.getDescripcion());
			stmt.setInt(2, r.getCodigo());
			stmt.executeUpdate();
			
		}  catch (SQLException e) {
			throw new SQLException("Hubo un error en la base de datos", e);
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
	}
	
	
}
