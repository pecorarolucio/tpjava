package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Categoria;
import entities.Pelicula;
import entities.Sala;
import logic.CategoriaABMC;

public class DataSala {
	
	public LinkedList<Sala> getAll() throws SQLException {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Sala> salas= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from sala");
			if(rs!=null) {
				while(rs.next()) {
					Sala s= new Sala();
					s.setIdSala(rs.getInt("idsala"));
					s.setCapacidadMaxima(rs.getInt("capacidadMax"));
					salas.add(s);
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Hubo un error en la base de datos", e);
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
		return salas;
		}
		
	public void add(Sala s) throws SQLException {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("insert into sala(idsala,capacidadMax) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, s.getIdSala());
			stmt.setInt(2, s.getCapacidadMaxima());
			stmt.executeUpdate();
		
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                s.setIdSala(keyResultSet.getInt(1));
            }  		
		}  catch (SQLException e) {
            throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new SQLException("Hubo un error en la base de datos", e);
            }
		}
	}
	
	
	
	public void update (Sala s) throws SQLException {
		PreparedStatement stmt=null;
		try {
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update sala set capacidadMax = ? where idsala=?");
			stmt.setInt(1, s.getCapacidadMaxima());
			stmt.setInt(2, s.getIdSala());
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

	public Sala search(Sala s) throws SQLException { 
		PreparedStatement stmt =null;
		ResultSet rs=null;
		Sala sala=null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from sala where idsala = ?");
			stmt.setInt(1, s.getIdSala());
			
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				sala = new Sala();
				sala.setIdSala(rs.getInt("idsala"));
				sala.setCapacidadMaxima(rs.getInt("capacidadmax"));
				
			}
		} catch (SQLException e) {
			throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
		return sala;
		
	}
	

	public void delete (Sala s) throws SQLException {
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from sala where idsala = ?");
			stmt.setInt(1, s.getIdSala());
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

}
