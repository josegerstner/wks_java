package conectaBD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

@SuppressWarnings("serial")
class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox<>();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox<>();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		botonConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ejecutaConsulta();
				
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		/*
		 * CONEXION CON BBDD
		 */
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_pedidos_ejercicios?useSSL=false", "root", "root");
			
			Statement sentencia = miConexion.createStatement();
			
			// Carga JComboBox SECCIONES
			String consulta = "SELECT DISTINCTROW sección FROM productos";
			
			ResultSet rs = sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				secciones.addItem(rs.getString(1));
			}
			rs.close();
			
			// Carga JComboBox PAISES
			consulta = "SELECT DISTINCTROW país_de_origen FROM productos";
			
			rs = sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				paises.addItem(rs.getString(1));
			}
			rs.close();
			
			
		}catch(Exception e) {
			
		}
		
	}	
		
	private void ejecutaConsulta(){
		
		ResultSet rs = null;
		
		try {
			
			resultado.setText("");
			
			String seccion = (String) secciones.getSelectedItem();
			String pais= (String) paises.getSelectedItem();
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
				enviaConsultaSeccion = miConexion.prepareStatement(consultaSeccion);
				enviaConsultaSeccion.setString(1, seccion);
				rs = enviaConsultaSeccion.executeQuery();
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaPais = miConexion.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs = enviaConsultaPais.executeQuery();
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaTodos = miConexion.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs = enviaConsultaTodos.executeQuery();
			}
			
			while(rs.next()) {
				resultado.append(rs.getString(1));
				resultado.append(", ");
				resultado.append(rs.getString(2));
				resultado.append(", ");
				resultado.append(rs.getString(3));
				resultado.append(", ");
				resultado.append(rs.getString(4));
				resultado.append("\n");
			}
			
		}catch(Exception e) {
			
		}
	}
	
	private Connection miConexion;
	
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	
	private final String consultaSeccion = "SELECT nombre_artículo, sección, precio, país_de_origen FROM productos WHERE sección = ?";
	private final String consultaPais = "SELECT nombre_artículo, sección, precio, país_de_origen FROM productos WHERE país_de_origen = ?";
	private final String consultaTodos = "SELECT nombre_artículo, sección, precio, país_de_origen FROM productos WHERE sección = ? AND país_de_origen = ?";
	
	private JComboBox<String> secciones;
	private JComboBox<String> paises;
	private JTextArea resultado;
}