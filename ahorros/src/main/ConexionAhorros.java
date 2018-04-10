package main;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConexionAhorros {
	ConexionAhorros(){
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "Grn 1988!");
			miConexion.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha fallado la conexión");
			e.printStackTrace();
		}
	}
}
