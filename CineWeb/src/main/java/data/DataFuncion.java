package data;

import java.util.LinkedList;
import java.sql.*;
import entities.Categoria;
import entities.Funcion;
import entities.Pelicula;
import entities.Sala;

public class DataFuncion {

  public void add(Funcion f) throws SQLException {
		PreparedStatement stmt= null;
		ResultSet ResultSet=null;
		System.out.println();
		System.out.println("Fecha de función: " + f.getFechaFuncion());
		System.out.println("Hora de inicio: " + f.getHoraInicio());
		System.out.println("Hora de fin: " + f.getHoraFin());
		System.out.println("Sala: " + f.getSala());
		System.out.println("Película: " + f.getPelicula());
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("insert into funcion (fecha, HoraInicio, HoraFin, IDSala, IDPelicula) values(?,?,?,?,?)");
			stmt.setDate(1, Date.valueOf(f.getFechaFuncion())); //SOLUCION TEMPORAL, NO SE SI ES CORRECTO PARA TRANSFORMAR LOCALDATE A DATE DE SQL
			stmt.setTime(2, Time.valueOf(f.getHoraInicio()));
			stmt.setTime(3, Time.valueOf(f.getHoraFin()));
			stmt.setInt(4, f.getSala().getIdSala());
			stmt.setInt(5, f.getPelicula().getIdPelicula());
			stmt.executeUpdate();
			
		}  catch (SQLException e) {
            throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
            try {
                if(ResultSet!=null)ResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new SQLException("Hubo un error en la base de datos", e);
            }
		  }
    }

  public LinkedList<Funcion> getFunciones(Pelicula p) throws SQLException {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		Funcion f = null;
		LinkedList<Funcion> funciones = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
						"select f.HoraInicio, f.HoraFin, f.fecha, f.IDSala, sal.capacidadmax, p.nombre, p.idCategoria, cat.nombre, "+
						"cat.nombre "+
						"from funcion f "+
						"inner join sala sal "+
						"on sal.idSala = f.idSala "+
						"inner join pelicula p "+
						"on p.idPelicula = f.idPelicula "+
						"inner join categoria cat "+
						"on  p.idCategoria = cat.idCategoria  "+
						"where p.idPelicula= ? and CURDATE()<=f.fecha" //EL CURDATE() ES PARA OBTENER LA FECHA ACTUAL, ASI OBTENGO LAS FUNCIONES DISPONIBLES 
						);
			stmt.setInt(1, p.getIdPelicula());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while (rs.next()){
					Categoria c = new Categoria(rs.getInt("idCategoria"), rs.getString("nombre"));
					p.setNombrePelicula(rs.getString("nombre"));
					p.setCategoria(c);
					Sala s = new Sala(rs.getInt("idSala"),rs.getInt("capacidadmax"));
					f = new Funcion(rs.getDate("fecha").toLocalDate(), rs.getTime("HoraInicio").toLocalTime(), rs.getTime("HoraFin").toLocalTime(), s, p);
					f.setSala(s); //LA SALA SOLO TIENE CARGADA UNA ID PARA MOSTRAR
					funciones.add(f);
				}
			}
		} catch(SQLException e)  {
			throw new SQLException("Hubo un error en la base de datos", e);
		} finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				throw new SQLException("Hubo un error en la base de datos", e);
			}
		}
		return funciones;
	}
  public void delete (Funcion f) throws SQLException {
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from funcion where fecha = ? and HoraInicio = ? and idSala = ?");
			stmt.setDate(1, Date.valueOf(f.getFechaFuncion()));
			stmt.setTime(2, Time.valueOf(f.getHoraInicio()));
			stmt.setInt(3, f.getSala().getIdSala());
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
  
  public Funcion findOne(Funcion f) throws SQLException {
	  Funcion fun = new Funcion();
	  PreparedStatement stmt=null;
	  ResultSet rs = null;
	  try {
		  stmt=DbConnector.getInstancia().getConn().prepareStatement("select * from funcion inner join sala s on s.idsala = funcion.IDSala where fecha = ? and HoraInicio = ? and funcion.IDSala = ?");
		  stmt.setDate(1, Date.valueOf(f.getFechaFuncion()));
		  stmt.setTime(2, Time.valueOf(f.getHoraInicio()));
		  stmt.setInt(3, f.getSala().getIdSala());
		  rs = stmt.executeQuery();
		  if(rs!=null && rs.next()) {
			  fun.setFechaFuncion(rs.getDate("fecha").toLocalDate());
			  fun.setHoraInicio(rs.getTime("HoraInicio").toLocalTime());
			  fun.setHoraFin(rs.getTime("HoraFin").toLocalTime());
			  Sala s = new Sala();
			  s.setIdSala(rs.getInt("s.idsala"));
			  s.setCapacidadMaxima(rs.getInt("s.capacidadmax"));
			  fun.setSala(s);
			  Pelicula p = new Pelicula();
			  p.setIdPelicula(rs.getInt("IDPelicula"));
			  fun.setPelicula(p);
		  }
	  } catch(SQLException e) {
		  throw new SQLException("Hubo un error en la base de datos", e);
	  } finally {
		  try {
			  if(stmt!=null) stmt.close();
			  if(rs!=null) rs.close();
			  DbConnector.getInstancia().releaseConn();
		  } catch(SQLException e) {
			  throw new SQLException("Hubo un error en la base de datos", e);
		  }
	  }
	  return fun;
  }
  
  public void update(Funcion f) throws SQLException {
	  PreparedStatement stmt=null;
	  try {
		  stmt=DbConnector.getInstancia().getConn().prepareStatement("update funcion set fecha = ?, HoraInicio = ?, HoraFin = ?, IDSala = ?, IDPelicula = ? where fecha = ? and HoraInicio = ? and IDSala = ?");
		  stmt.setDate(1, Date.valueOf(f.getFechaFuncion()));
		  stmt.setTime(2, Time.valueOf(f.getHoraInicio()));
		  stmt.setTime(3, Time.valueOf(f.getHoraFin()));
		  stmt.setInt(4, f.getSala().getIdSala());
		  stmt.setInt(5, f.getPelicula().getIdPelicula());
		  stmt.setDate(6, Date.valueOf(f.getFechaFuncion()));
		  stmt.setTime(7, Time.valueOf(f.getHoraInicio()));
		  stmt.setInt(8, f.getSala().getIdSala());
		  stmt.executeUpdate();
	  } catch(SQLException e) {
		  throw new SQLException("Hubo un error en la base de datos", e);
	  } finally {
		  try {
			  if(stmt!=null) stmt.close();
			  DbConnector.getInstancia().releaseConn();
		  } catch(SQLException e) {
			  throw new SQLException("Hubo un error en la base de datos", e);
		  }
	  }
  }
  
  //FALTA EL UPDATE PERO PARA EL AD O CON LE TIEMPO RESTANTE LO PODEMOS HACER
		
}
