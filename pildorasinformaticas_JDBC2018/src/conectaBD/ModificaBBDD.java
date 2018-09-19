package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {
	public static void main(String[] args) {
		
		try{
			//1. Crear conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_pedidos_ejercicios?useSSL=false", "root", "root");
			
			//2. Crear Statement
			Statement miStatement = miConexion.createStatement();
			
			//String instruccionSQL = "INSERT INTO productos(c�digo_art�culo, nombre_art�culo, precio) VALUES ('AR77', 'PANTAL�N', 25.35)";
			//String instruccionSQL = "UPDATE productos SET precio = precio*2 WHERE c�digo_art�culo = 'AR77'";
			String instruccionSQL = "DELETE FROM productos WHERE c�digo_art�culo = 'AR77'";
			
			//3. Ejecutar SQL
			
			miStatement.executeUpdate(instruccionSQL);
			
			//System.out.println("Datos insertados correctamente");
			//System.out.println("Datos modificados correctamente");
			System.out.println("Datos eliminados correctamente");
			
			
			// Leo los datos para ver que sea cierto lo que hace
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM productos");
			
			//4. Leer el ResultSet
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("nombre_art�culo") + " " + 
						miResultSet.getString("c�digo_art�culo") + " " +
						miResultSet.getString("precio") + " " +
						miResultSet.getDate("fecha"));
			}
		}catch(Exception e) {
			System.out.println("No conecta");
			e.printStackTrace();
		}

	}

}
