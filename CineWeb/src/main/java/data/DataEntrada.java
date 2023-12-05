package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;

import entities.Entrada;
import entities.Funcion;
import entities.Persona;
import entities.Sala;

public class DataEntrada {

	public Entrada findOne(int cod) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Entrada ent = new Entrada();
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("Select * from Entrada where codentrada = ?");
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			 if (rs != null && rs.next()) {
				 	Persona p = new Persona();
				 	Sala s = new Sala();
				 	p.setId(rs.getInt("nroUsuario"));
				 	s.setIdSala(rs.getInt("IDSala"));
		            ent.setCodEntrada(cod);
		            ent.setPersona(p);
		            ent.setPrecio(rs.getInt("precio"));
		            Funcion f = new Funcion();
		            f.setFechaFuncion(rs.getDate("fecha").toLocalDate());
		            f.setHoraInicio(rs.getTime("HoraInicio").toLocalTime());
		            f.setSala(s);
		            ent.setFuncion(f);
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
		return ent;
	}
	
	public LinkedList<Entrada> findFromUser(int nroUsuario) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Entrada> entradas = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("Select codentrada, IDSala, fecha, HoraInicio, precio"
					+ "from entrada where nroUsuario = ?");
			rs = stmt.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					Persona p = new Persona();
					p.setId(nroUsuario);
					Sala s = new Sala();
					s.setIdSala(rs.getInt("IDSala"));
					Entrada ent = new Entrada();
					ent.setCodEntrada(rs.getInt("codentrada"));
					ent.setPersona(p);
					ent.setPrecio(rs.getInt("precio"));
					Funcion f = new Funcion();
					f.setHoraInicio(rs.getTime("HoraInicio").toLocalTime());
					f.setFechaFuncion(rs.getDate("fecha").toLocalDate());
					f.setSala(s);
					ent.setFuncion(f);
					entradas.add(ent);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null)rs.close();
				if (stmt!=null) stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return entradas;
	}
	
	public LinkedList<Entrada> findFromFuncion(Funcion f){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Entrada> entradas = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("Select codentrada, nroUsuario, precio from entrada"
					+ " where fecha = ? and HoraInicio = ? and IDSala = ?");
			stmt.setDate(1, Date.valueOf(f.getFechaFuncion()));
			stmt.setTime(2, Time.valueOf(f.getHoraInicio()));
			stmt.setInt(3, f.getSala().getIdSala());
			rs = stmt.executeQuery();
			if (rs!=null) {
				while(rs.next()) {
					Persona p = new Persona();
					p.setId(rs.getInt("nroUsuario"));
					Sala s = new Sala();
					s.setIdSala(f.getSala().getIdSala());
					Entrada ent = new Entrada();
					ent.setCodEntrada(rs.getInt("codentrada"));
					ent.setPrecio(rs.getInt("precio"));
					ent.setPersona(p);
					ent.setFuncion(f);
					entradas.add(ent);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return entradas;
	}
	
	public void add(Entrada ent) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into entrada(precio, fecha, HoraInicio, IDSala, nroUsuario) values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS );
			stmt.setInt(1, ent.getPrecio());
			stmt.setDate(2, Date.valueOf(ent.getFuncion().getFechaFuncion()));
			stmt.setTime(3, Time.valueOf(ent.getFuncion().getHoraInicio()));
			stmt.setInt(4, ent.getFuncion().getSala().getIdSala());
			stmt.setInt(5, ent.getPersona().getId());
			stmt.executeUpdate();
			
			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet!=null && keyResultSet.next()) {
				ent.setCodEntrada(keyResultSet.getInt(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(keyResultSet!=null) keyResultSet.close();
				if(stmt!=null) stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete (Entrada ent) {
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from entrada where codentrada = ?");
			stmt.setInt(1, ent.getCodEntrada());
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
