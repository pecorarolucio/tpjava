package data;

import java.sql.*;

import entities.Reseña;

public class DataReseña {
	
	public void add(Reseña r) {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("insert into reseña (descripcion, fecha, idPelicula, nrousuario) values(?. ?. ?. ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, r.getDescripcion());
			stmt.setDate(2, Date.valueOf(r.getFecha()));
			stmt.setInt(3, r.getPelicula().getIdPelicula());
			stmt.setInt(4, r.getAutor().getNroUsuario());
			
			keyResultSet=stmt.getGeneratedKeys();
			if (keyResultSet!=null && keyResultSet.next()) {
				r.setCodigo(keyResultSet.getInt(1));
			}
		}	catch(SQLException e) {
				e.printStackTrace();
		}	finally {
			 try {
	                if(keyResultSet!=null)keyResultSet.close();
	                if(stmt!=null)stmt.close();
	                DbConnector.getInstancia().releaseConn();
	            } catch (SQLException e) {
	            	e.printStackTrace();
	            }
			}
	    }
	
	public void delete(Reseña r) {
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
	
	public Reseña search(Reseña r) {
		PreparedStatement stmt =null;
		ResultSet rs=null;
		Reseña res= null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
							   "select r.codigo, r.descripcion, r.fecha, r.idPelicula, r.nrousuario"
							 + "from reseña r "
							 + "where r.codigo=?"
								);
			
			stmt.setInt(1, r.getCodigo());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				res=new Reseña();
				res.setCodigo(rs.getInt("r.codigo"));				
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
}