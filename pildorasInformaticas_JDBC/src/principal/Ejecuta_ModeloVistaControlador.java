package principal;

import javax.swing.JFrame;

import vista.MarcoAplicacion;

public class Ejecuta_ModeloVistaControlador {
	public static void main(String[] args) {
		MarcoAplicacion miMarco = new MarcoAplicacion();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}
