package graficos;
import java.awt.event.*;
import javax.swing.*;
public class EventosTeclado {
	public static void main(String[] args) {
		MarcoConTeclado mimarco = new MarcoConTeclado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConTeclado extends JFrame{
	public MarcoConTeclado(){
		setTitle("Eventos de teclado");
		setBounds(300, 300, 500, 350);
		setVisible(true);
		addKeyListener(new EventoDeTeclado());
	}
}
class EventoDeTeclado extends KeyAdapter{
	public void keyPressed(KeyEvent e){ //cuando la tecla es presionada
		System.out.println(e.getKeyCode());
	}
	public void keyReleased(KeyEvent e){} //cuando la tecla es soltada
	
	public void keyTyped(KeyEvent e){ //cuando ocurrieron los eventos anteriores (keyPressed keyReleased)
		System.out.println(e.getKeyChar());
	}
}