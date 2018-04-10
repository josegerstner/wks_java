package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class PruebaDisposicionesSpring {
	public static void main(String[] args) {
		MarcoSpring miMarco = new MarcoSpring();
		miMarco.setVisible(true);
	}
}
@SuppressWarnings("serial")
class MarcoSpring extends JFrame{
	public MarcoSpring(){
		setTitle("Pruebas de la disposición Spring");
		setBounds(400, 200, 450, 400);
		
		LaminaSpring miLamina = new LaminaSpring();
		add(miLamina);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
@SuppressWarnings("serial")
class LaminaSpring extends JPanel{
	public LaminaSpring(){
		JButton boton1 = new JButton("boton 1");
		JButton boton2 = new JButton("boton 2");
		JButton boton3 = new JButton("boton 3");
		SpringLayout miLayout = new SpringLayout();
		//creamos una instancia Spring con un valor elástico
		Spring miSpring = Spring.constant(0, 10, 100);
		//creamos una instancia Spring con un valor rígido
		Spring springRigido = Spring.constant(60);
		
		setLayout(miLayout);
		add(boton1);
		add(boton2);
		add(boton3);
		
		//metemos un Spring entre el WEST del layout y el botón1
		miLayout.putConstraint(SpringLayout.WEST, boton1, miSpring, SpringLayout.WEST, this);
		//metemos un Spring entre el boton1 y el botón2
		miLayout.putConstraint(SpringLayout.WEST, boton2, springRigido, SpringLayout.EAST, boton1);
		//metemos un Spring entre el boton2 y el botón3
		miLayout.putConstraint(SpringLayout.WEST, boton3, springRigido, SpringLayout.EAST, boton2);
		//metemos un Spring entre el boton3 y el EAST del layout
		miLayout.putConstraint(SpringLayout.EAST, this, miSpring, SpringLayout.EAST, boton3);
		
	}
}