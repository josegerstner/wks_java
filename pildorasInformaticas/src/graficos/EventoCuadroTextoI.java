package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class EventoCuadroTextoI {
	public static void main(String[] args) {
		MarcoEventoTextoI miMarco = new MarcoEventoTextoI();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MarcoEventoTextoI extends JFrame{
	public MarcoEventoTextoI(){
		setTitle("Eventos de texto");
		setBounds(400, 200, 450, 300);
		LaminaEventoTextoI miLamina = new LaminaEventoTextoI();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaEventoTextoI extends JPanel{
	public LaminaEventoTextoI(){
		JTextField miCampo = new JTextField(20);
		EscuchaTexto evento = new EscuchaTexto();
		Document miDoc = miCampo.getDocument();
		miDoc.addDocumentListener(evento);
		add(miCampo);
	}
	private class EscuchaTexto implements DocumentListener{
		//este método reconoce cuando se cambia alguna propiedad del texto (cursiva, negrita, etc)
		public void changedUpdate(DocumentEvent d) {
			
		}
		//este método reconoce cuando se ingresa texto
		public void insertUpdate(DocumentEvent d) {
			System.out.println("Has insertado texto");
		}
		//este método reconoce cuando se borra texto
		public void removeUpdate(DocumentEvent d) {
			System.out.println("Has borrado texto");
		}
		
	}
}