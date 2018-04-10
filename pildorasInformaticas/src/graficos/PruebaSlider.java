package graficos;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class PruebaSlider {
	public static void main(String[] args) {
		MarcoSlider miMarco = new MarcoSlider();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoSlider extends JFrame{
	public MarcoSlider(){
		setTitle("Ejemplo de JSlider");
		setBounds(400, 200, 500, 300);
		LaminaSlider miLamina = new LaminaSlider();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaSlider extends JPanel{
	public LaminaSlider(){
		//instanciamos el JSlider con un rango de 0 a 100 y 50 como valor inicial
		JSlider control = new JSlider(0, 100, 50);
		//definimos que la orientación va a ser horizontal (horizontal viene por defecto igualmente)
		control.setOrientation(SwingConstants.HORIZONTAL);
		//las marcas mayores van de 25 en 25
		control.setMajorTickSpacing(25);
		//las marcas menores van de 5 en 5
		control.setMinorTickSpacing(5);
		//establecemos un valor true para que nos muestre las marcas
		control.setPaintTicks(true);
		//definimos el tipo de letra para que muestre los números
		control.setFont(new Font("Serif", Font.ITALIC, 12));
		//establecemos un valor verdadero para que nos muestre los números
		control.setPaintLabels(true);
		//establecemos un valor true para que se imante el cursor a las marcas
		control.setSnapToTicks(true);
		add(control);
	}
}