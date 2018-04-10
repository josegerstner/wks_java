package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PruebaSliderII {
	public static void main(String[] args) {
		MarcoSliderII miMarco = new MarcoSliderII();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoSliderII extends JFrame{
	public MarcoSliderII(){
		setTitle("Ejemplo de JSlider");
		setBounds(400, 200, 500, 300);
		LaminaSliderII miLamina = new LaminaSliderII();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaSliderII extends JPanel{
	public LaminaSliderII(){
		setLayout(new BorderLayout());
		rotulo = new JLabel("Plateado sobre plateado");
		add(rotulo, BorderLayout.CENTER);
		
		control = new JSlider(8, 48, 12);
		control.setMajorTickSpacing(20);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		control.setFont(new Font("Serif", Font.ITALIC, 12));
		control.addChangeListener(new EventoSlider());
		JPanel laminaSlider = new JPanel();
		laminaSlider.add(control);
		add(laminaSlider, BorderLayout.NORTH);
	}
	private class EventoSlider implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			rotulo.setFont(new Font("Serif", Font.ITALIC, control.getValue()));
		}
	}
	private JLabel rotulo;
	private JSlider control;
}