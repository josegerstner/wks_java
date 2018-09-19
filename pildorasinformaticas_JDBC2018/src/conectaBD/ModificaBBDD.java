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
			
			//String instruccionSQL = "INSERT INTO productos(código_artículo, nombre_artículo, precio) VALUES ('AR77', 'PANTALÓN', 25.35)";
			//String instruccionSQL = "UPDATE productos SET precio = precio*2 WHERE código_artículo = 'AR77'";
			String instruccionSQL = "DELETE FROM productos WHERE código_artículo = 'AR77'";
			
			//3. Ejecutar SQL
			
			miStatement.executeUpdate(instruccionSQL);
			
			//System.out.println("Datos insertados correctamente");
			//System.out.println("Datos modificados correctamente");
			System.out.println("Datos eliminados correctamente");
			
			
			// Leo los datos para ver que sea cierto lo que hace
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM productos");
			
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
