package stored_procedures;
import java.sql.*;

import javax.swing.JOptionPane;
public class ActualizaProductos {
	public static void main(String[] args) {
		String nPrecio = JOptionPane.showInputDialog("Introduce precio");
		String nArticulo = JOptionPane.showInputDialog("Introduce Artículo");
		try{
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "Grn 1988!");
			CallableStatement miSentencia = miConexion.prepareCall("{call ACTUALIZA_PRODUCTOS(?, ?)}");
			
			//LE PASAMOS LOS ARGUMENTOS AL STORED PROCEDURE
			miSentencia.setString(1, nPrecio);
			miSentencia.setString(2, nArticulo);
			
			miSentencia.execute();
			
			System.out.println("Actualización OK");
		}catch(Exception e){
			System.out.println("NO CONECTA!!!");
			e.printStackTrace();
		}
	}
}
