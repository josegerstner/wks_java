package graficos;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutsGrid {
	public static void main(String[] args) {
		MarcoLayoutGrid miMarco = new MarcoLayoutGrid();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoLayoutGrid extends JFrame{
	public MarcoLayoutGrid(){
		setTitle("Prueba acciones");
		setBounds(400, 200, 500, 350);
		PanelLayoutGrid miLamina = new PanelLayoutGrid();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class PanelLayoutGrid extends JPanel{
	public PanelLayoutGrid(){
		setLayout(new GridLayout(3,2));
		add(new JButton("Rojo"));
		add(new JButton("Verde"));
		add(new JButton("Azul"));
		add(new JButton("Naranja"));
		add(new JButton("Amarillo"));
		add(new JButton("Negro"));
	}
}