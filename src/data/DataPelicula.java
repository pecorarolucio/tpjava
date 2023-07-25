package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Categoria;
import entities.Pelicula;





public class DataPelicula {
	
	public LinkedList<Pelicula> getPeliculasxCategoria(Categoria c){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Pelicula> peliculas= new LinkedList<>();
		Pelicula p = null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
				   "select p.id, p.nombre "
				 + "from pelicula p "
				 + "inner join categoria c "
				 + "on c.id = p.idCategoria "
				 + "where p.idCategoria=? "
					);
			stmt.setInt(1, c.getIdCategoria());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					p = new Pelicula(rs.getInt("id"),rs.getString("nombre"),c);
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
					prepareStatement("insert into pelicula(id,idCategoria,nombre) values(?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getIdPelicula());
			stmt.setInt(2, p.getCategoria().getIdCategoria());
			stmt.setString(3, p.getNombrePelicula());
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
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update pelicula set idCategoria = ?, nombre= ? where id=?");
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
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from pelicula where id = ?");
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

}