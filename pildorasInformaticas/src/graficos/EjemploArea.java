package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EjemploArea {

	public static void main(String[] args) {
		MarcoArea miMarco = new MarcoArea();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MarcoArea extends JFrame{
	public MarcoArea(){
		setTitle("Ejemplo de �rea de texto");
		setBounds(400, 200, 450, 300);
		LaminaArea miLamina = new LaminaArea();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaArea extends JPanel{
	public LaminaArea(){
		//instanciamos el �rea de texto
		miArea = new JTextArea(8, 20);
		//le damos barra de desplazamiento a miArea para que no se deforme a lo alto
		JScrollPane barraDesplazamiento = new JScrollPane(miArea);
		//establecemos que el �rea tenga saltos de l�nea autom�ticos para que no se deforme a lo ancho
		//si comentamos esta opci�n, usar� una barra de desplazamiento a lo ancho
		miArea.setLineWrap(true);
		//agregamos la l�mina de barraDesplazamiento porque ya contiene a miArea
		add(barraDesplazamiento);
		//creamos el bot�n enviar
		JButton enviar = new JButton("Enviar");
		enviar.addActionListener(new GestionArea());
		add(enviar);
	}
	private class GestionArea implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println(miArea.getText());
		}
	}
	private JTextArea miArea;
}