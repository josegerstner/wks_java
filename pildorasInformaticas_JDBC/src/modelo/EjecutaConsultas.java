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
	private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	private final String consultaAmbos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
	private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS";
}
