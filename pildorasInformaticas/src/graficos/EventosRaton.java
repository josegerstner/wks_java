package graficos;
import java.awt.event.*;
import javax.swing.*;
public class EventosRaton {
	public static void main(String[] args) {
		MarcoConRaton mimarco = new MarcoConRaton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConRaton extends JFrame{
	public MarcoConRaton(){
		setTitle("Eventos de ratón");
		setBounds(300, 100, 500, 350);
		setVisible(true);
		addMouseListener(new EventoDeRaton());
	}
}
class EventoDeRaton implements MouseListener{//Se implementa la interfaz MouseListener
	public void mouseClicked(MouseEvent e){//cuando haces un clic (presionar y soltar)
		System.out.println("Has hecho click");
	}
	public void mousePressed(MouseEvent e){//cuando presionas el ratón
		System.out.println("Acabas de presionar");
	}
	public void mouseReleased(MouseEvent e){//cuando sueltas el ratón
		System.out.println("Acabas de levantar");
	}
	public void mouseEntered(MouseEvent e){//cuando el ratón entra al marco
		System.out.println("El mouse ha entrado al marco");
	}
	public void mouseExited(MouseEvent e){//cuando el ratón sale del marco
		System.out.println("El mouse ha salido del marco");
	}
}