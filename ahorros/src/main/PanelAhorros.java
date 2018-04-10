package main;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelAhorros extends JPanel{
	PanelAhorros(){
		Box cajaNuevo = Box.createHorizontalBox();
		nuevo = new JLabel("Ingresar nuevo ahorro: ");
		cNuevo = new JTextField(10);
		cajaNuevo.add(nuevo);
		cajaNuevo.add(cNuevo);
		
		Box contenedor = Box.createVerticalBox();
		contenedor.add(cajaNuevo);
		
		add(contenedor);
		
	}
	JLabel nuevo;
	JTextField cNuevo;
}