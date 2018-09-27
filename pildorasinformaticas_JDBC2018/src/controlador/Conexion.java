package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	Connection miConexion = null;
	
	
	
	public Conexion() {
		
	}
	
	public Connection dameConexion() {
		
			try {
				
				miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_pedidos_ejercicios?useSSL=false", "root", "root");
				
			}catch(Exception e) {
			
		}
			return miConexion;
	}
	
}
