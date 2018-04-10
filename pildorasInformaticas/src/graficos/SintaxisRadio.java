package graficos;
import javax.swing.*;
public class SintaxisRadio {
	public static void main(String[] args) {
		MarcoRadio miMarco = new MarcoRadio();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoRadio extends JFrame{
	public MarcoRadio(){
		setTitle("Ejemplo de botones radio");
		setBounds(400, 200, 450, 300);
		LaminaRadio miLamina = new LaminaRadio();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaRadio extends JPanel{
	public LaminaRadio(){
		ButtonGroup colores = new ButtonGroup();
		ButtonGroup fuentes = new ButtonGroup();
		JRadioButton boton1 = new JRadioButton("Azul", false);
		JRadioButton boton2 = new JRadioButton("Rojo", true);
		JRadioButton boton3 = new JRadioButton("Amarillo", false);
		JRadioButton boton4 = new JRadioButton("Negrita", true);
		JRadioButton boton5 = new JRadioButton("Cursiva", false);
		//agregamos los botones al grupo al que perteneces
		colores.add(boton1);
		colores.add(boton2);
		colores.add(boton3);
		fuentes.add(boton4);
		fuentes.add(boton5);
		//agregamos los botones a la lámina
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
	}
}