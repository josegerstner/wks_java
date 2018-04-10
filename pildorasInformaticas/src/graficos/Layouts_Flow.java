package graficos;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts_Flow {
	public static void main(String[] args) {
		MarcoLayoutFlow miMarco = new MarcoLayoutFlow();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MarcoLayoutFlow extends JFrame{
	public MarcoLayoutFlow(){
		setTitle("Prueba Layout Flow");
		setBounds(400, 200, 500, 350);
		PanelLayoutFlow miLamina = new PanelLayoutFlow();
		//creamos una instacia de FlowLAyout y la agregamos a la l�mina
		//FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
		//miLamina.setLayout(disposicion);
		//visto de otra manera
		//miLamina.setLayout(new FlowLayout(FlowLayout.LEFT));
		//o con otro contructor
		miLamina.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 150));
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class PanelLayoutFlow extends JPanel{
	public PanelLayoutFlow(){
		add(new JButton("Amarillo"));
		add(new JButton("Azul"));
		add(new JButton("Rojo"));
	}
}