package data;

import java.sql.*;
import entities.Persona;
import java.util.LinkedList;


public class DataPersona {
	
	public LinkedList<Persona> getAll() throws SQLException {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> personas= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuario");
			if(rs!=null) {
				while(rs.next()) {
					Persona p= new Persona();
					p.setId(rs.getInt("nrousuario"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setMail(rs.getString("mail"));
					p.setContraseña(rs.getString("contraseña"));
					p.setTipo(rs.getString("Tipo"));
					personas.add(p);
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
		return personas;
		
	};
	
	public LinkedList<Persona> getClientes() throws SQLException {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> clientes= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuario where tipo='Cliente' ");
			if(rs!=null) {
				while(rs.next()) {
					Persona p= new Persona();
					p.setId(rs.getInt("nrousuario"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setMail(rs.getString("mail"));
					clientes.add(p);
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
		return clientes;
		
	};
	
	
	public Persona findByMail(Persona p) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona per = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select mail from usuario where mail = ?");
			stmt.setString(1, p.getMail());
			
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				per = new Persona();
				per.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
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
		
	return per;
	}
	
	public Persona getOne(Persona p) throws SQLException {
		PreparedStatement stmt =null;
		ResultSet rs=null;
		Persona per=null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from usuario where mail = ? and contraseña = ?");
			stmt.setString(1, p.getMail());
			stmt.setString(2, p.getContraseña());
			
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				per = new Persona();
				per.setId(rs.getInt("nrousuario"));
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setMail(rs.getString("mail"));
				per.setContraseña(rs.getString("contraseña"));
				per.setTipo(rs.getString("Tipo"));
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
		return per;
	}
	
	public Persona getByID(int id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona per = null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("select nombre from usuario where nrousuario = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
		//	if (rs!=null) {
		//		per = new Persona();
		//		per.setId(id);
		//		per.setNombre(rs.getString("nombre"));
		//	}
			if (rs.next()) { // Verificar si hay alguna fila en el ResultSet
	            per = new Persona();
	            per.setId(id);
	            per.setNombre(rs.getString("nombre"));
	        }
		} catch(SQLException e) {
			throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.cancel();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
		return per;
	}
	
	public void add(Persona p) throws SQLException {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("insert into usuario(nombre,apellido,mail,contraseña,Tipo) values(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getMail());
			stmt.setString(4, p.getContraseña());
			stmt.setString(5, p.getTipo());
			stmt.executeUpdate();
		
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId(keyResultSet.getInt(1));
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
	
	public void update(Persona p) throws SQLException {
		PreparedStatement stmt=null;
		try {
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update usuario set nombre = ?, apellido = ?, mail = ?, contraseña =? where nrousuario=?");
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getMail());
			stmt.setString(4, p.getContraseña());
			stmt.setInt(5, p.getId());
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
	
	public void delete(Persona p) throws SQLException{
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from usuario where nrousuario = ?");
			stmt.setInt(1, p.getId());
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
