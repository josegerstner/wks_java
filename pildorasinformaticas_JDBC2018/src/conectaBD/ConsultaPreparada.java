package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaPreparada {
	public static void main(String[] args) {
		
		try{
			//1. Crear conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_pedidos_ejercicios?useSSL=false", "root", "root");
			
			//2. Preparar consulta
			PreparedStatement miSentencia = miConexion.prepareStatement("SELECT nombre_artículo, sección, país_de_origen "
					+ "FROM productos WHERE sección = ? AND país_de_origen = ?");
			
			//3. Establecer parámetros de consulta
			miSentencia.setString(1, "deportes");
			miSentencia.setString(2, "USA");
			
			//4. Ejecutar y recorrer consulta
			System.out.println("Ejecución primera consulta\n");
			ResultSet rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			
			//Bonus. Reutilización de consulta SQL
			System.out.println("\nEjecución segunda consulta\n");
			//3. Establecer parámetros de consulta
			miSentencia.setString(1, "cerámica");
			miSentencia.setString(2, "China");
			
			//4. Ejecutar y recorrer consulta
			rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			
			
		}catch(Exception e) {
			System.out.println("No conecta");
			e.printStackTrace();
		}

	}
}
