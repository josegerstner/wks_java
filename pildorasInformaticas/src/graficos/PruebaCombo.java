package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaCombo {
	public static void main(String[] args) {
		MarcoCombo miMarco = new MarcoCombo();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoCombo extends JFrame{
	public MarcoCombo(){
		setTitle("Ejemplo de combo box");
		setBounds(400, 200, 500, 300);
		LaminaCombo miLamina = new LaminaCombo();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaCombo extends JPanel{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LaminaCombo(){
		setLayout(new BorderLayout());
		//Instanciamos el texto, definimos su fuente y posici�n en la l�mina 
		texto = new JLabel("Yendo de la cama al living");
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		add(texto, BorderLayout.CENTER);
		//Instanciamos otra l�mina
		JPanel laminaNorte = new JPanel();
		//Instanciamos el JComboBox, le agregamos los �tems, lo agregamos a la l�mina nueva y agregamos esa l�mina a la principal
		miCombo = new JComboBox();
		miCombo.setEditable(true);
		miCombo.addItem("Serif");
		miCombo.addItem("Impact");
		miCombo.addItem("Monospaced");
		miCombo.addItem("Dialog");
		EventoCombo miEvento = new EventoCombo();
		miCombo.addActionListener(miEvento);
		laminaNorte.add(miCombo);
		add(laminaNorte, BorderLayout.NORTH);
		//
		
	}
	private class EventoCombo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			texto.setFont(new Font((String)miCombo.getSelectedItem(), Font.PLAIN, 18));
		}
		
	}
	private JLabel texto;
	@SuppressWarnings("rawtypes")
	private JComboBox miCombo;
}