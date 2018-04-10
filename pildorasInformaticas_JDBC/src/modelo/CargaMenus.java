package modelo;
import java.sql.*;
public class CargaMenus {
	public CargaMenus(){
		miConexion = new Conexion();
	}
	public void ejecutaConsultas(){
		Productos miProducto = null;
		Connection accesoBBDD = miConexion.dameConexion();
		try{
			miProducto = new Productos();
			Statement secciones = accesoBBDD.createStatement();
			Statement paises = accesoBBDD.createStatement();
			rs = secciones.executeQuery("SELECT DISTINCTROW SECCI�N FROM PRODUCTOS");
			rs2 = paises.executeQuery("SELECT DISTINCTROW PA�SDEORIGEN FROM PRODUCTOS");
			
			miProducto.setSeccion(rs.getString(1));
			miProducto.setpOrigen(rs2.getString(1));
			
			rs.close();
			rs2.close();
			accesoBBDD.close();
		}catch(Exception e){
			System.out.println("ERROR en CARGA MENUS");
			e.printStackTrace();
		}
		//return miProducto;
	}
	/*public void ejecutaConsultas(){
		Productos miProducto = null;
		Connection accesoBBDD = miConexion.dameConexion();
		try{
			Statement secciones = accesoBBDD.createStatement();
			rs = secciones.executeQuery("SELECT DISTINCTROW SECCI�N FROM PRODUCTOS");
			while(rs.next()){
				miProducto = new Productos();
				miProducto.setSeccion(rs.getString(1));
			}
			rs.close();
		}catch(Exception e){
			System.out.println("ERROR en CARGA MENUS");
			e.printStackTrace();
		}
		//return miProducto.getSeccion();
	}*/
	private Conexion miConexion;
	public ResultSet rs;
	public ResultSet rs2;
}
