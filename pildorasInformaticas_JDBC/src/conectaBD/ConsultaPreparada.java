package conectaBD;
import java.sql.*;
public class ConsultaPreparada {
	public static void main(String[] args) {
		try {
			//1. CREAR CONEXIÓN
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "Grn 1988!");
			
			//2. PREPARAR CONSULTA
			
			PreparedStatement miSentencia = miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
			
			//3. ESTABLECER PARÁMETROS DE CONSULTA
			
			miSentencia.setString(1, "Deportes");
			
			miSentencia.setString(2, "USA");
			
			//4. EJEUTAR SQL
			
			ResultSet miRS = miSentencia.executeQuery();
			
			while(miRS.next()){
				System.out.println(miRS.getString(1) + " " + miRS.getString(2) + " " + miRS.getString(3));
			}
			
			//5. LIBERAMOS LA MEMORIA
			
			miRS.close();
			
			
			//REUTILIZACIÓN DE CONSULTA
			
			System.out.println();
			System.out.println("EJECUCIÓN SEGUNDA CONSULTA");
			System.out.println();
			
			miSentencia.setString(1, "Cerámica");
			
			miSentencia.setString(2, "China");
			
			miRS = miSentencia.executeQuery();
			
			while(miRS.next()){
				System.out.println(miRS.getString(1) + " " + miRS.getString(2) + " " + miRS.getString(3));
			}
			
			miRS.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
}
