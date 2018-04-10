package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PruebasDisposicionesLibres {
	public static void main(String[] args) {
		MarcoLibre miMarco = new MarcoLibre();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoLibre extends JFrame{
	public MarcoLibre(){
		setTitle("Pruebas de disposiciones libre");
		setBounds(400, 200, 450, 400);
		add(new LaminaLibre());
		
	}
}
@SuppressWarnings("serial")
class LaminaLibre extends JPanel{
	public LaminaLibre(){
		//al marcar el set layout como null, significa usar la disposición libre
		//setLayout(null);
		setLayout(new EnColumnas());
		
		JLabel nombre = new JLabel("Nombre");
		JLabel apellido = new JLabel("Apellido");
		JLabel edad = new JLabel("Edad");
		JLabel telefono = new JLabel("Teléfono");
		JTextField _nombre = new JTextField();
		JTextField _apellido = new JTextField();
		JTextField _edad = new JTextField();
		JTextField _telefono = new JTextField();
		
		//nombre.setBounds(20, 20, 80, 15);
		//_nombre.setBounds(100, 17, 100, 20);
		//apellido.setBounds(20, 60, 80, 15);
		//_apellido.setBounds(100, 55, 100, 20);
		
		add(nombre);
		add(_nombre);
		add(apellido);
		add(_apellido);
		add(edad);
		add(_edad);
		add(telefono);
		add(_telefono);
	}
}

class EnColumnas implements LayoutManager{
	public EnColumnas(){
		
	}
	@Override
	public void addLayoutComponent(String name, Component comp) {
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		
		return null;
	}

	@Override
	public void layoutContainer(Container miContenedor) {
		int contador = 0;
		int d = miContenedor.getWidth();
		x = d/2;
		int n = miContenedor.getComponentCount();
		for(int i=0; i<n; i++){
			contador++;
			Component c = miContenedor.getComponent(i);
			//c.setBounds(x-100, y, 100, 20);
			System.out.println("i: " + i + " " + "n: " + n);
			c.setLocation(x-100, y);
			c.setSize(100, 20);
			x+=100;
			if(contador%2==0){
				x=d/2;
				y+=40;
			}
		}
	}
	private int x=0;
	private int y = 20;
}