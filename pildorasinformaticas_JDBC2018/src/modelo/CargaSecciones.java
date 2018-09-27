package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import controlador.Conexion;

public class CargaSecciones {

	public CargaSecciones() {
		
		miConexion = new Conexion();
		
	}
	
	public String ejecutaConsulta() {
		
		Productos miProducto = null;
		
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
			
			Statement secciones = accesoBBDD.createStatement();
			
			rs = secciones.executeQuery("SELECT DISTINCTROW sección FROM productos");
			
			while(rs.next()) {
				
				miProducto = new Productos();
				
				miProducto.setSeccion(rs.getString(1));
				
				return miProducto.getSeccion();
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return miProducto.getSeccion();
		
	}
	
	Conexion miConexion;
	
	public ResultSet rs;
}
