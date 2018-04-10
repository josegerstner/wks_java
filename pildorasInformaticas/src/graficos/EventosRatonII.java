package graficos;
import java.awt.event.*;
import javax.swing.*;
public class EventosRatonII {
	public static void main(String[] args) {
		MarcoConRatonII mimarco = new MarcoConRatonII();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConRatonII extends JFrame{
	public MarcoConRatonII(){
		setTitle("Eventos de rat�n");
		setBounds(450, 200, 500, 350);
		setVisible(true);
		addMouseListener(new EventoDeRatonII());
		addMouseMotionListener(new MovimientoRaton());
	}
}
class EventoDeRatonII extends MouseAdapter{//Se hereda de la clase MouseAdapter
	public void mouseClicked(MouseEvent e){//cuando haces un clic (presionar y soltar)
		System.out.println("Coordenada X: " + e.getX());//getX() devuelve la coordenada en X
		System.out.println("Coordenada Y: " + e.getY());//getY() devuelve la coordenada en Y
		System.out.println(e.getClickCount());//cuenta los clics hechos
	}
	public void mousePressed(MouseEvent e){
		//getModifiersEx() devuelve el c�digo del bot�n pulsado
		if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK){
			System.out.println("Has pulsado el bot�n izquierdo");
		}else if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK){
			System.out.println("Has pulsado la rueda del rat�n");
		}else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK){
			System.out.println("Has pulsado el bot�n derecho");
		}
	}
}
class MovimientoRaton implements MouseMotionListener{//MouseMotionListener reconoce los movimientos del rat�n
	public void mouseDragged(MouseEvent e) {//cuando el rat�n se mueve presionando /arrastra un objeto
		System.out.println("Est�s arrastrando");
	}
	public void mouseMoved(MouseEvent e) {//cuando el rat�n se mueve sin presionar
		System.out.println("Est�s moviendo el rat�n");
	}
	
}