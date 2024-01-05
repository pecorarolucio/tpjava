package data;

import java.sql.*;
import java.util.LinkedList;

import entities.AppException;
import entities.Categoria;




public class DataCategoria {
	
	public Categoria findOne(int id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Categoria cat = new Categoria();
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("Select * from categoria where idcategoria = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
		//	if (rs!=null) {
		//		cat.setIdCategoria(id);
		//		cat.setNombreCategoria(rs.getString("nombre"));
		//	}
			 if (rs != null && rs.next()) {
		            cat.setIdCategoria(id);
		            cat.setNombreCategoria(rs.getString("nombre"));
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
		return cat;
	}
	
	public LinkedList<Categoria> getAll() throws SQLException {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Categoria> categorias= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from categoria");
			if(rs!=null) {
				while(rs.next()) {
					Categoria c= new Categoria();
					c.setIdCategoria(rs.getInt("idcategoria"));
					c.setNombreCategoria(rs.getString("nombre"));
					categorias.add(c);
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
		return categorias;
		}
		
	
	
	public void add(Categoria c) throws SQLException, AppException {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("insert into categoria(nombre) values(?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getNombreCategoria());
			stmt.executeUpdate();
		
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                c.setIdCategoria(keyResultSet.getInt(1));
            }
            
		}  catch (SQLException e) {
            throw new SQLException("Hubo un error en la base de datos", e);
		}
		finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new SQLException("Hubo un error en la base de datos", e);
            }
		}
	}
	
	
	
	public void update (Categoria cat) throws SQLException {
		PreparedStatement stmt=null;
		try {
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update categoria set nombre = ? where idcategoria=?");
			stmt.setString(1, cat.getNombreCategoria());
			stmt.setInt(2, cat.getIdCategoria());
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

	public Categoria search(Categoria c ) throws SQLException { 
		PreparedStatement stmt =null;
		ResultSet rs=null;
		Categoria cat=null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from categoria where idcategoria = ?");
			stmt.setInt(1, c.getIdCategoria());
			
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				cat = new Categoria();
				cat.setIdCategoria(rs.getInt("idcategoria"));
				cat.setNombreCategoria(rs.getString("nombre"));
				
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
		return cat;
		
	}
	

	public void delete (Categoria cat) throws SQLException {
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from categoria where idcategoria = ?");
			stmt.setInt(1, cat.getIdCategoria());
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
