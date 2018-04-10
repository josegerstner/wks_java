package aplicacion_consulta;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AplicacionConsulta {
	public static void main(String[] args) {
		MarcoAplicacion miMarco = new MarcoAplicacion();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class MarcoAplicacion extends JFrame{
	public MarcoAplicacion(){
		setTitle("Consulta BBDD");
		setBounds(400,200,400, 400);
		setLayout(new BorderLayout());
		
		JPanel menus = new JPanel();
		menus.setLayout(new FlowLayout());
		
		secciones = new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("Todos");
		
		paises = new JComboBox();
		paises.setEditable(false);
		paises.addItem("Todos");
		
		resultado = new JTextArea(4, 50);
		resultado.setEditable(false);
		
		menus.add(secciones);
		menus.add(paises);
		
		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		JButton botonConsulta = new JButton("Consulta");
		botonConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutaConsulta();
			}
		});
		add(botonConsulta, BorderLayout.SOUTH);
		
		//-----------CONEXIÓN CON BBDD-------------
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "Grn 1988!");
			Statement sentencia = miConexion.createStatement();
			
			//CARGA JCOMBOBOX SECCIONES
			String consulta = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
			ResultSet rs = sentencia.executeQuery(consulta);
			while(rs.next()){
				secciones.addItem(rs.getString(1));
			}
			rs.close();

			//CARGA JCOMBOBOX PAÍSES
			consulta = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
			rs = sentencia.executeQuery(consulta);
			while(rs.next()){
				paises.addItem(rs.getString(1));
			}
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		setVisible(true);
	}
	private void ejecutaConsulta(){
		ResultSet rs = null;
		try{
			String seccion = (String) secciones.getSelectedItem();
			String pais = (String) paises.getSelectedItem();
			if(!seccion.equals("Todos") && pais.equals("Todos")){
				enviaConsultaSeccion = miConexion.prepareStatement(consultaSeccion);
				enviaConsultaSeccion.setString(1, seccion);
				rs = enviaConsultaSeccion.executeQuery();
			}else if(seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsultaPais = miConexion.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs = enviaConsultaPais.executeQuery();
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsultaTodos = miConexion.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs = enviaConsultaTodos.executeQuery();
			}else{
				PreparedStatement ps = miConexion.prepareStatement("SELECT * FROM PRODUCTOS");
				rs = ps.executeQuery();
			}
			resultado.setText("");
			while(rs.next()){
				//imprimimos el resultado de la consulta en el JTextArea
				resultado.append(rs.getString(1));
				resultado.append(", ");
				resultado.append(rs.getString(2));
				resultado.append(", ");
				resultado.append(rs.getString(3));
				resultado.append(", ");
				resultado.append(rs.getString(4));
				resultado.append("\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private Connection miConexion;
	private PreparedStatement enviaConsultaSeccion, enviaConsultaPais, enviaConsultaTodos;
	private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
	private JComboBox secciones, paises;
	private JTextArea resultado;
}