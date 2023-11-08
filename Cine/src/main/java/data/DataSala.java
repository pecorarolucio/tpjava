package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Sala;

public class DataSala {
	public LinkedList<Sala> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Sala> salas= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from sala");
			if(rs!=null) {
				while(rs.next()) {
					Sala s= new Sala();
					s.setIdSala(rs.getInt("id"));
					s.setCapacidadMaxima(rs.getInt("capacidadMax"));
					salas.add(s);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return salas;
		}
		
	public void add(Sala s) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("insert into sala(id,capacidadMax) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, s.getIdSala());
			stmt.setInt(2, s.getCapacidadMaxima());
			stmt.executeUpdate();
		
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                s.setIdSala(keyResultSet.getInt(1));
            }  		
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	
	
	public void update (Sala s) {
		PreparedStatement stmt=null;
		try {
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update sala set capacidadMax = ? where id=?");
			stmt.setInt(1, s.getCapacidadMaxima());
			stmt.setInt(2, s.getIdSala());
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

	public Sala search(Sala s){ 
		PreparedStatement stmt =null;
		ResultSet rs=null;
		Sala sala=null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from sala where id = ?");
			stmt.setInt(1, s.getIdSala());
			
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				sala = new Sala();
				sala.setIdSala(rs.getInt("id"));
				sala.setCapacidadMaxima(rs.getInt("nombre"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sala;
		
	}
	

	public void delete (Sala s){
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from sala where id = ?");
			stmt.setInt(1, s.getIdSala());
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

}
