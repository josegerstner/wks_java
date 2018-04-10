package graficos;
import java.awt.event.*;
import javax.swing.*;
public class EventosVentana {
	public static void main(String[] args) {
		MarcoVentana mimarco = new MarcoVentana();
		mimarco.setTitle("Ventana 1");
		mimarco.setBounds(200, 100, 400, 400);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcoVentana mimarco2 = new MarcoVentana();
		mimarco2.setTitle("Ventana 2");
		mimarco2.setBounds(700, 200, 200, 200);
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoVentana extends JFrame{
	public MarcoVentana(){
		//setTitle("Trabajando con eventos de ventana");
		//setSize(400,400);
		setVisible(true);
		VentanaOyente oyente = new VentanaOyente();
		addWindowListener(oyente);
	}
}
class VentanaOyente implements WindowListener{
	public void windowActivated(WindowEvent e){
		System.out.println("Ventana activada");
	}
	public void windowClosed(WindowEvent e){
		System.out.println("Ventana cerrada");
	}
	public void windowClosing(WindowEvent e){
		System.out.println("Cerrando ventana");
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("Ventana desactivada");
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("Ventana restaurada");
	}
	public void windowIconified(WindowEvent e){
		System.out.println("Ventana minimizada");
	}
	public void windowOpened(WindowEvent e){
		System.out.println("Ventana abierta");
	}
}