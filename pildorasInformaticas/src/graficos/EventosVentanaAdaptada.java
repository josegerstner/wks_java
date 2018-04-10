package graficos;
import java.awt.event.*;
import javax.swing.*;
public class EventosVentanaAdaptada {
	public static void main(String[] args) {
		MarcoVentanaAdaptado mimarco = new MarcoVentanaAdaptado();
		mimarco.setTitle("Ventana 1");
		mimarco.setBounds(200, 100, 400, 400);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcoVentanaAdaptado mimarco2 = new MarcoVentanaAdaptado();
		mimarco2.setTitle("Ventana 2");
		mimarco2.setBounds(700, 200, 200, 200);
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoVentanaAdaptado extends JFrame{
	public MarcoVentanaAdaptado(){
		setVisible(true);
		addWindowListener(new VentanaOyenteAdaptada());
	}
}
class VentanaOyenteAdaptada extends WindowAdapter{
	public void windowIconified(WindowEvent e){
		System.out.println("Ventana minimizada");
	}
}