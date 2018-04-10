package basesdedatos;

import java.sql.SQLException;

import vehiculo.Taxi;
import vehiculo.TaxiCRUD;

/*************************************************************************
 * 
 *                                  JDBC
 * 									****
 * Es una API que permite la ejecución de operaciones sobre bases de datos
 * o BBDD desde el lenguaje de programación Java :D
 * 
 * JDBC ofrece el paquete java.sql con clases útiles para trabajar con BBDD.
 * CLASES:
 * 		DriverManager: para cargar un driver
 * 		Connection: Para establecer conexiones con las bases de datos
 * 		Statement: Para ejecutar sentencias SQL y enviarlas a las BBDD
 * 		ResultSet: Para almacenar el resultado de la consulta
 *
 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
public class Principal {
	public static void main(String[] args) throws SQLException {
		//BaseDeDatos baseDeDatos = new BaseDeDatos();
		//baseDeDatos.conectar();
		
		Taxi taxi = new Taxi("AAA123", "Ford", "Focus", 2017);
		TaxiCRUD taxiCRUD = new TaxiCRUD();
		taxiCRUD.agregar(taxi);
	}

}
