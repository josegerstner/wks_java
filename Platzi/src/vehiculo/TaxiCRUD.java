package vehiculo;

import java.sql.SQLException;
import java.sql.Statement;

import basesdedatos.BaseDeDatos;

public class TaxiCRUD {
	private final String TIPO = "1";
	public void agregar(Taxi taxi) throws SQLException{
		String query = "";
		Statement sentencia = null;
		String nombre = "INSERT INTO vehiculo"
				+ "(matricula, marca, modelo, anio, id_tipo_vehiculo)"
				+ "VALUES ('"+taxi.getMatricula()+"', '"+taxi.getMarca()+"',"
				+ " '"+taxi.getModelo()+"', '"+taxi.getAnio()+"',"
				+ "'"+TIPO+"')";
		BaseDeDatos baseDeDatos = new BaseDeDatos();
		sentencia = baseDeDatos.conectar().createStatement();
		if(sentencia.executeUpdate(query) > 0){
			System.out.println("El registro se insertó correctamente");
		}else{
			System.out.println("No se puedo agregar el registro: "+query);
		}
	}
	public void editar(Taxi taxi){
		
	}
	public void eliminar(Taxi taxi){
		
	}
}
