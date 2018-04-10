package graficos;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
public class EjemploRadio {
	public static void main(String[] args) {
		MarcoExampleRadio miMarco = new MarcoExampleRadio();
			miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoExampleRadio extends JFrame{
	public MarcoExampleRadio(){
		setTitle("Ejemplo de botones radio");
		setBounds(400, 200, 500, 300);
		LaminaExampleRadio miLamina = new LaminaExampleRadio();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaExampleRadio extends JPanel{
	public LaminaExampleRadio(){
		//seteo el layout que voy a usar
		setLayout(new BorderLayout());
		//instancio el texto y le digo en dónde va a estar agregándolo a la lámina
		texto = new JLabel("En un lugar de la concha de tu madre all boys");
		texto.setFont(new Font("Serif", Font.PLAIN, 14));
		add(texto, BorderLayout.CENTER);
		//creo un grupo e instancio los botones
		ButtonGroup miGrupo = new ButtonGroup();
		boton1 = new JRadioButton("Pequeño", false);
		boton2 = new JRadioButton("Mediano", true);
		boton3 = new JRadioButton("Grande", false);
		boton4 = new JRadioButton("Muy Grande", false);
		//instancio el evento y pongo a la escucha a los botones
		EventoRadio evento = new EventoRadio();
		boton1.addActionListener(evento);
		boton2.addActionListener(evento);
		boton3.addActionListener(evento);
		boton4.addActionListener(evento);
		//creo un panel secundario, agrego los botones al grupo y al panel
		JPanel laminaRadio = new JPanel();
		miGrupo.add(boton1);
		miGrupo.add(boton2);
		miGrupo.add(boton3);
		miGrupo.add(boton4);
		laminaRadio.add(boton1);
		laminaRadio.add(boton2);
		laminaRadio.add(boton3);
		laminaRadio.add(boton4);
		//añado la lámina secundaria a la lámina principal e indico su ubicación
		add(laminaRadio, BorderLayout.SOUTH);
	}
	private class EventoRadio implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==boton1){
				texto.setFont(new Font("Serif", Font.PLAIN, 10));
			}else if(e.getSource()==boton2){
				texto.setFont(new Font("Serif", Font.PLAIN, 14));
			}else if(e.getSource()==boton3){
				texto.setFont(new Font("Serif", Font.PLAIN, 18));
			}else if(e.getSource()==boton4){
				texto.setFont(new Font("Serif", Font.PLAIN, 24));
			}
		}
		
	}
	private JLabel texto;
	private JRadioButton boton1, boton2, boton3, boton4;
}