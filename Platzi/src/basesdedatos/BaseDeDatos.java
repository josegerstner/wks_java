package basesdedatos;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class BaseDeDatos {
	//jdc
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String DB = "platzijava";
	private final String USUARIO = "platzijava";
	private final String PASSWORD = "platzijava";
	public Connection conexion = null;
	
	@SuppressWarnings("finally")
	public Connection conectar() throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
			if(conexion != null){
				System.out.println("La conexión se ejecutó exitosamente");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		} finally {
			return conexion;
		}
	}
}
