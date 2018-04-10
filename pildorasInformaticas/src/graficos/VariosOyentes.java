package graficos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class VariosOyentes {
	public static void main(String[] args) {
		MarcoPrincipal mimarco = new MarcoPrincipal();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

@SuppressWarnings("serial")
class MarcoPrincipal extends JFrame{
	public MarcoPrincipal(){
		setTitle("Prueba varios oyentes");
		setBounds(700, 50, 500, 350);
		add(new LaminaPrincipal());
	}
}

@SuppressWarnings("serial")
class LaminaPrincipal extends JPanel{
	public LaminaPrincipal(){
		JButton botonNuevo = new JButton("Nuevo");
		add(botonNuevo);
		botonCerrar = new JButton("Cerrar todo");
		add(botonCerrar);
		OyenteNuevo miOyente = new OyenteNuevo();
		botonNuevo.addActionListener(miOyente);
	}
	private class OyenteNuevo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MarcoEmergente marcoNuevo = new MarcoEmergente(botonCerrar);
			marcoNuevo.setVisible(true);
		}
		
	}
	JButton botonCerrar;
}
@SuppressWarnings("serial")
class MarcoEmergente extends JFrame{
	//le pasamos al constructor el botón al cual quiero que se aplique el evento
	public MarcoEmergente(JButton botonDeMarcoPrincipal){
		contador++;
		setTitle("Ventana " + contador);
		setBounds(40*contador, 40*contador, 300, 150);
		OyenteCerrar nuevoOyente = new OyenteCerrar();
		botonDeMarcoPrincipal.addActionListener(nuevoOyente);
	}
	private class OyenteCerrar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//transforma un objeto seteado como visible como no visible
			dispose();
			//reseteamos la variable para que empiece nuevamente
			contador = 0;
		}
	}
	private static int contador = 0;
}