package data;

import java.sql.*;

public class DbConnector {
	
	private static DbConnector instancia;
	
	//private String driver="com.mysql.cj.jdbc.Driver";
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="root";
	private String password="Kamp123QQ%%123";
	private String db="cinemanagement"; //tabla
	private int conectados=0;
	private Connection conn;
	
	private DbConnector() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DbConnector getInstancia() {
		if (instancia == null) {
			instancia = new DbConnector();
		}
		return instancia;
	}
	
	public Connection getConn(){
	    try {
	        if (conn == null || conn.isClosed()) {
	            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, password);
	            conectados++;
	            System.out.println("Conexión establecida: " + conn);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return conn;
	}

	
	public void releaseConn() {
		
		try {
			conectados--;
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}

