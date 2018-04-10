package videojuegos;

import javax.swing.JFrame;

public class Inicio {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Zelda");
		ventana.setVisible(true);
		ventana.setSize(900, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.add(new Lienzo());
	}
}
