package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FocoVentana extends JFrame implements WindowFocusListener{

	public static void main(String[] args) {
		FocoVentana miVentana = new FocoVentana();
		miVentana.iniciar();
	}
	public void iniciar(){
		marco1 = new FocoVentana();
		marco2 = new FocoVentana();
		marco1.setVisible(true);
		marco2.setVisible(true);
		marco1.setBounds(300, 100, 300, 350);
		marco2.setBounds(750, 100, 200, 350);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.addWindowFocusListener(this);
		marco2.addWindowFocusListener(this);
	}

	public void windowGainedFocus(WindowEvent e) {
		if(e.getSource()==marco1){
			marco1.setTitle("Tengo el puto foco");
		}else{
			marco2.setTitle("Tengo el puto foco");
		}
	}
	public void windowLostFocus(WindowEvent e) {
		if(e.getSource()==marco1){
			marco1.setTitle("");
		}else{
			marco2.setTitle("");
		}
	}
	FocoVentana marco1;
	FocoVentana marco2;
}

