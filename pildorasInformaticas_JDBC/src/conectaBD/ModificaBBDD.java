package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModificaBBDD {
	public static void main(String[] args) {
		try{
		
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "Grn 1988!");
				
			Statement miStatement = miConexion.createStatement();
			
			//para insertar un registro nuevo
			//String instruccionSQL = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR77', 'PANTALÓN', 25.35);";
			
			//para actualizar información de un registro
			//String instruccionSQL = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77';";
			
			//para borrar un registro
			String instruccionSQL = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77';";
			
			miStatement.executeUpdate(instruccionSQL);
			
			System.out.println("Datos MODIFICADOS correctamente");
		}catch(Exception e){
			System.out.println("NO CONECTA!!!");
			e.printStackTrace();
		}
	}
}
