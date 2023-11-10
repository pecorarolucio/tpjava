package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Categoria;
import entities.Cliente;
import entities.Funcion;
import entities.Pelicula;
import entities.Reseña;
import entities.Sala;




public class DataPelicula {
	
	public LinkedList<Pelicula>getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Pelicula> peliculas = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select IDpelicula, nombre from pelicula");
			if(rs!=null) {
				while(rs.next()) {
					Pelicula p= new Pelicula();
					p.setIdPelicula(rs.getInt("idPelicula"));
					p.setNombrePelicula(rs.getString("nombre"));
					peliculas.add(p);
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
		return peliculas;
		}
	
	public LinkedList<Pelicula> getPeliculasxCategoria(Categoria c){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Pelicula> peliculas= new LinkedList<>();
		Pelicula p = null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
				   "select p.idpelicula, p.nombre "
				 + "from pelicula p "
				 + "inner join categoria c "
				 + "on c.idcategoria = p.idCategoria "
				 + "where p.idCategoria=?"
					);
			
			stmt.setInt(1, c.getIdCategoria());
			rs= stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					p = new Pelicula(rs.getInt("idpelicula"),rs.getString("nombre"),c);
					peliculas.add(p);
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
		return peliculas;
		}

	public void add(Pelicula p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("insert into pelicula(idCategoria,nombre) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getCategoria().getIdCategoria());
			stmt.setString(2, p.getNombrePelicula());
			stmt.executeUpdate();
		
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdPelicula(keyResultSet.getInt(1));
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

	public void update(Pelicula p) {
		PreparedStatement stmt=null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update pelicula set idcategoria=?, nombre=? where idpelicula=?");
			stmt.setInt(1, p.getCategoria().getIdCategoria());
			stmt.setString(2, p.getNombrePelicula());
			stmt.setInt(3, p.getIdPelicula());
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

	
	public void delete (Pelicula p) {
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from pelicula where idpelicula = ?");
			stmt.setInt(1, p.getIdPelicula());
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
	
	public LinkedList<Reseña> getReseñas(String p){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Reseña> reseñas = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT p.nombrePelicula, r.username, r.fecha, r.descripcion"+
					"FROM pelicula p"+
					"INNER JOIN reseña r ON p.idpelicula = r.idPelicula"+
					"WHERE p.nombre = ?");
			stmt.setString(1, p);
			rs = stmt.executeQuery();
			if(rs!=null) {
				while (rs.next()) {
					Reseña r = new Reseña();
					Cliente c = new Cliente();
					c.setUsername(rs.getString("r.username"));
					r.setAutor(c);//SOLO RECUPERO EL USERNAME DEL AUTOR DE LA RESEÑA
					r.setDescripcion(rs.getString("r.descripcion"));
					r.setFecha(rs.getDate("r.fecha").toLocalDate());
					reseñas.add(r);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return reseñas;
	}
	
	//NO ESTOY SEGURO SI ESTO VA ACA O HAY QUE HACER UN DATAFUNCION
	public LinkedList<Funcion> getFunciones(String p){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Funcion> funciones = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
						"SELECT f.horaInicio, f.horaFin, f.fecha, f.idSala"+
						"FROM funcion f " +
						"INNER JOIN pelicula p ON f.idPelicula = p.idpelicula "+
						"AND p.nombre = ?");
			stmt.setString(1, p);
			rs = stmt.executeQuery();
			if(rs!=null) {
				while (rs.next()){
					Funcion f = new Funcion();
					Sala s = new Sala();
					f.setHoraInicio(rs.getTime("f.horaInicio").toLocalTime());
					f.setHoraFin(rs.getTime("f.horaFin").toLocalTime());
					f.setFechaFuncion(rs.getDate("f.fecha").toLocalDate());
					s.setIdSala(rs.getInt("f.idSala"));
					f.setSala(s); //LA SALA SOLO TIENE CARGADA UNA ID PARA MOSTRAR
					funciones.add(f);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return funciones;
	}

}
