package data;

public class DataFuncion {

  public void add(Funcion f) {
		PreparedStatement stmt= null;
		ResultSet ResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("insert into funcion (fecha, horaInicio, horaFin, idSala, idPelicula) values(?,?,?,?,?)");
			stmt.setDate(1, Date.valueOf(f.getFechaFuncion())); //SOLUCION TEMPORAL, NO SE SI ES CORRECTO PARA TRANSFORMAR LOCALDATE A DATE DE SQL
			stmt.setTime(2, Time.valueOf(f.getHoraInicio()));
			stmt.setTime(3, Time.valueOf(f.getHoraFin()));
			stmt.setInt(3, f.getSala().getIdSala());
			stmt.setInt(4, f.getPelicula().getIdPelicula());
		
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(ResultSet!=null)ResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		  }
    }

  public LinkedList<Funcion> getFunciones(Pelicula p){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		Funcion f = null;
		LinkedList<Funcion> funciones = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
						"select f.horaInicio, f.horaFin, f.fecha, f.idSala, sal.capacidadmax, p.nombre, p.idCategoria, cat.nombre "+
						"nombreCategoria "+
						"from funcion f "+
						"inner join sala sal "+
						"on sal.idSala = f.idSala "+
						"inner join pelicula p "+
						"on p.idPelicula = f.idPelicula "+
						"inner join categoria cat "+
						"on  p.idCategoria = cat.idCategoria  "+
						"where p.idPelicula= ?"
						);
			stmt.setInt(1, p.getIdPelicula());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while (rs.next()){
					Categoria c = new Categoria(rs.getInt("idCategoria"), rs.getString("nombreCategoria"));
					p.setNombrePelicula(rs.getString("nombre"));
					p.setCategoria(c);
					Sala s = new Sala(rs.getInt("idSala"),rs.getInt("capacidadmax"));
					f = new Funcion(rs.getDate("fecha").toLocalDate(), rs.getTime("horaInicio").toLocalTime(), rs.getTime("horaFin").toLocalTime(), s, p);
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
  public void delete (Funcion f) {
		PreparedStatement stmt =null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from funcion where fecha = ? and horaInicio = ? and idSala = ?");
			stmt.setDate(1, Date.valueOf(f.getFechaFuncion()));
			stmt.setTime(2, Time.valueOf(f.getHoraInicio()));
			stmt.setInt(3, f.getSala().getIdSala());
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
