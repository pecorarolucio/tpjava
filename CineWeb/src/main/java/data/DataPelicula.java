package data;

import java.sql.*;
import java.util.LinkedList;
import entities.Categoria;
import entities.Funcion;
import entities.Pelicula;
import entities.Sala;
import logic.CategoriaABMC;



public class DataPelicula {
	
	public Pelicula findOne(Pelicula p) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		Pelicula pel = new Pelicula();
		Categoria c = new Categoria();
		CategoriaABMC cl = new CategoriaABMC();
		Integer id = p.getIdPelicula();
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from pelicula where idpelicula = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			//if (rs !=null) {
			//	pel.setIdPelicula(id);
			//	pel.setNombrePelicula(rs.getString("nombre"));
			//	c = cl.getOne(rs.getInt("idcategoria"));
			//	pel.setCategoria(c);
			//}
			 if (rs.next()) { // Verifica si hay al menos una fila en el ResultSet
	                pel.setIdPelicula(id);
	                pel.setNombrePelicula(rs.getString("nombre"));
	                c = cl.getOne(rs.getInt("idcategoria"));
	                pel.setCategoria(c);
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
		return pel;
	}
	
	public LinkedList<Pelicula>getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Pelicula> peliculas = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idpelicula, nombre from pelicula");
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
	

	
	//NO ESTOY SEGURO SI ESTO VA ACA O HAY QUE HACER UN DATAFUNCION
	/*public LinkedList<Funcion> getFunciones(Pelicula p){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		LinkedList<Funcion> funciones = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
						"SELECT f.horaInicio, f.horaFin, f.fecha, f.idSala"+
						"FROM funcion f " +
						"INNER JOIN pelicula p ON f.idPelicula = p.idpelicula "+
						"WHERE p.idpelicula=?");
			stmt.setInt(1, p.getIdPelicula());
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
					f.setPelicula(p);
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
	}*/

}
