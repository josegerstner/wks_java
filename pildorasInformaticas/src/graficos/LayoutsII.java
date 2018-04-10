package graficos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutsII {
	public static void main(String[] args) {
		MarcoLayoutII miMarco = new MarcoLayoutII();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoLayoutII extends JFrame{
	public MarcoLayoutII(){
		setTitle("Prueba acciones");
		setBounds(400, 200, 500, 350);
		PanelLayoutI miLaminaI = new PanelLayoutI();
		PanelLayoutII miLaminaII = new PanelLayoutII();
		//para poder agregar las dos láminas, necesito especificar dónde van a estar, sino se pisan
		add(miLaminaI, BorderLayout.NORTH);
		add(miLaminaII, BorderLayout.SOUTH);
	}
}
/*
 * CREAMOS DOS PANELES/LÁMINAS Y LE DAMOS DIFERENTES DISPOSICIONES 
 */
@SuppressWarnings("serial")
class PanelLayoutI extends JPanel{
	public PanelLayoutI(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JButton("Amarillo"));
		add(new JButton("Azul"));
	}
}
@SuppressWarnings("serial")
class PanelLayoutII extends JPanel{
	public PanelLayoutII(){
		setLayout(new BorderLayout());
		add(new JButton("Rojo"), BorderLayout.EAST);
		add(new JButton("Verde"), BorderLayout.WEST);
		add(new JButton("Naranja"), BorderLayout.CENTER);
	}
}