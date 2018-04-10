package stored_procedures;
import java.sql.*;
public class ConsultaClientes {
	public static void main(String[] args) {
		try{
			
			//1. ESTABLECER CONEXION CON LA BASE DE DATOS
				Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "Grn 1988!");
				
			//2. CREAR OBJETO STATEMENT
				CallableStatement miSentencia = miConexion.prepareCall("{call MUESTRA_CLIENTES}");
			//3. EJECUTAR SENTENCIA SQL
				ResultSet rs = miSentencia.executeQuery();
				
			//4. RECORRER EL RESULTSET
				while(rs.next()){
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}
				
				rs.close();
			}catch(Exception e){
				System.out.println("NO CONECTA!!!");
				e.printStackTrace();
			}
	}
}
