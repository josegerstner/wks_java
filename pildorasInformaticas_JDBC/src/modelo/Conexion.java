package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public Conexion(){
		
	}
	public Connection dameConexion(){
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "Grn 1988!");
		}catch(Exception e){
			System.out.println("ERROR de CONEXION");
		}
		return miConexion;
	}
	private Connection miConexion = null;
}
