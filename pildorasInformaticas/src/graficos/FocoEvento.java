package graficos;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class FocoEvento {
	public static void main(String[] args) {
		MarcoConFoco mimarco = new MarcoConFoco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConFoco extends JFrame{
	public MarcoConFoco(){
		setTitle("Eventos de foco");
		setBounds(450, 200, 500, 350);
		setVisible(true);
		add(new LaminaFoco());
	}
}
@SuppressWarnings("serial")
class LaminaFoco extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//invalidamos el layout (diseño del panel)
		setLayout(null);
		//instanciamos los cuadros de texto
		cuadro1 = new JTextField();
		cuadro2 = new JTextField();
		//le damos dimensión a los cuadros de texto y les indicamos dónde posicionarse
		cuadro1.setBounds(120, 10, 150, 20);
		cuadro2.setBounds(120, 50, 150, 20);
		add(cuadro1);
		add(cuadro2);
		OyenteDeFoco oyenteFoco = new OyenteDeFoco();
		cuadro1.addFocusListener(oyenteFoco);
		//cuadro2.addFocusListener(oyenteFoco);
	}
	private class OyenteDeFoco implements FocusListener{
		//cuando un objeto gana el foco
		public void focusGained(FocusEvent e) {
			
		}
		//cuando un objeto pierde el foco
		public void focusLost(FocusEvent e) {
			String email = cuadro1.getText();
			boolean comprobacion = false;
			for(int i=0; i<email.length(); i++){
				if(email.charAt(i)=='@'){
					comprobacion = true;
				}
			}
			if(comprobacion){
				System.out.println("El mail es correcto");
			}else{
				System.out.println("El mail es incorrecto");
			}
		}
	}
	//creamos dos variables de la clase de cuadro de texto
	private JTextField cuadro1;
	private JTextField cuadro2;
}