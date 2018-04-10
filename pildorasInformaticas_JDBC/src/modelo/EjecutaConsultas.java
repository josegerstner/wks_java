package modelo;
import java.sql.*;

public class EjecutaConsultas {
	public EjecutaConsultas(){
		miConexion = new Conexion();
	}
	public ResultSet filtraBBDD(String seccion, String pais){
		Connection conecta = miConexion.dameConexion();
		rs = null;
		try{
			if(!seccion.equals("Todos") && pais.equals("Todos")){
				enviaConsulta = conecta.prepareStatement(consultaSeccion);
				enviaConsulta.setString(1, seccion);
				rs = enviaConsulta.executeQuery();
			}else if(seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsulta = conecta.prepareStatement(consultaPais);
				enviaConsulta.setString(1, pais);
				rs = enviaConsulta.executeQuery();
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsulta = conecta.prepareStatement(consultaAmbos);
				enviaConsulta.setString(1, seccion);
				enviaConsulta.setString(2, pais);
				rs = enviaConsulta.executeQuery();
			}else{
				Statement st = conecta.createStatement();				
				rs = st.executeQuery(consultaTodos);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	private Conexion miConexion;
	private ResultSet rs;
	private PreparedStatement enviaConsulta;
	private final String consultaSeccion = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N=?";
	private final String consultaPais = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE PA�SDEORIGEN=?";
	private final String consultaAmbos = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N=? AND PA�SDEORIGEN=?";
	private final String consultaTodos = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS";
}
