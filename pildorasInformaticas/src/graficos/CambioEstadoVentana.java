/*
 * La idea es crear un programa para informar si una ventana cambia su estado
 */
package graficos;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Frame;
public class CambioEstadoVentana {
	public static void main(String[] args) {
		MarcoEstado mimarco = new MarcoEstado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoEstado extends JFrame{
	public MarcoEstado(){
		setTitle("Estados de la ventana");
		setBounds(300, 300, 500, 350);
		setVisible(true);
		addWindowStateListener(new CambioEstado());//usamos este método para añadir un WindowStateListener al marco
	}
}
class CambioEstado implements WindowStateListener{//implementamos la interfaz WindowStateListener
	public void windowStateChanged(WindowEvent e){//sobreescribimos el método abstracto
		System.out.println("La ventana ha cambiado de estado");//informamos
		//System.out.println(e.getNewState());//imprimos el número de cambio de estado
		if(e.getNewState()==Frame.MAXIMIZED_BOTH){//si se maximiza la pantalla que me avise
			System.out.println("La ventana se ha maximizado");
		}else if(e.getNewState()==Frame.NORMAL){
			System.out.println("La ventana está normal");
		}else if(e.getNewState()==Frame.ICONIFIED){
			System.out.println("La ventana se ha minimizado");
		}
	}
}