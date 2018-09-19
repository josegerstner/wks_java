package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectaPruebas {

	public static void main(String[] args) {
		
		try{
			//1. Crear conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_pedidos_ejercicios?useSSL=false", "root", "root");
			
			//2. Crear Statement
			Statement miStatement = miConexion.createStatement();
			
			//3. Ejecutar SQL
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			//4. Leer el ResultSet
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("nombre_artículo") + " " + 
						miResultSet.getString("código_artículo") + " " +
						miResultSet.getString("precio") + " " +
						miResultSet.getDate("fecha"));
			}
		}catch(Exception e) {
			System.out.println("No conecta");
			e.printStackTrace();
		}

	}

}
