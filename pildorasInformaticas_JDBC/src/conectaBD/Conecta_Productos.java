package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conecta_Productos {
	public static void main(String[] args) {
		try{
			
		//1. ESTABLECER CONEXION CON LA BASE DE DATOS
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "Grn 1988!");
			
		//2. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();
			
		//3. EJECUTAR SENTENCIA SQL
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
		//4. RECORRER EL RESULTSET
			while(miResultSet.next()){
				System.out.println(miResultSet.getString("CÓDIGO ARTÍCULO") + " " + miResultSet.getString("NOMBRE ARTÍCULO") + " " + miResultSet.getString("PRECIO"));
			}
			
		}catch(Exception e){
			System.out.println("NO CONECTA!!!");
			e.printStackTrace();
		}
	}
}
