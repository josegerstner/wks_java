package graficos;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts_Border {
	public static void main(String[] args) {
		MarcoLayoutBorder miMarco = new MarcoLayoutBorder();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoLayoutBorder extends JFrame{
	public MarcoLayoutBorder(){
		setTitle("Prueba Border Layout");
		setBounds(400, 200, 500, 350);
		PanelLayoutBorder miLamina = new PanelLayoutBorder();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class PanelLayoutBorder extends JPanel{
	public PanelLayoutBorder(){
		//creamos una instacia de BorderLAyout y la agregamos a la l�mina
		//desde el contructor se puede especificar el espaciado entre componentes
		setLayout(new BorderLayout(10, 10));
		//para establecer la posici�n del bot�n se puede fijar en el constructor del bot�n
		add(new JButton("Amarillo"), BorderLayout.NORTH);
		add(new JButton("Azul"), BorderLayout.SOUTH);
		add(new JButton("Rojo"), BorderLayout.EAST);
		add(new JButton("Verde"), BorderLayout.WEST);
		add(new JButton("Naranja"), BorderLayout.CENTER);
	}
}