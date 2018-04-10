package graficos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
public class PruebaEventosII {
	public static void main(String[] args) {
		MarcoConBotonII mimarco = new MarcoConBotonII();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConBotonII extends JFrame{
	public MarcoConBotonII(){
		setTitle("Botones y eventos");
		setSize(400,400);
		LaminaConBotonII miLamina = new LaminaConBotonII();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class LaminaConBotonII extends JPanel{//debe implementar la interfaz ActionListener porque es la lámina la que va a recibir el evento
	JButton botonAzul = new JButton("Azul");//creamos un botón al que llamamos botonAzul con un texto en su interior("Azul")
	JButton botonVerde = new JButton("Verde");
	JButton botonRojo = new JButton("Rojo");
	
	public LaminaConBotonII(){
		add(botonAzul);//añadimos el botón a la lámina
		add(botonVerde);
		add(botonRojo);
		
		ColorFondo azul = new ColorFondo(Color.BLUE);
		ColorFondo verde = new ColorFondo(Color.GREEN);
		ColorFondo rojo = new ColorFondo(Color.RED);
		
		botonAzul.addActionListener(azul);
		botonVerde.addActionListener(verde);
		botonRojo.addActionListener(rojo);
	}
	private class ColorFondo implements ActionListener{
		public ColorFondo(Color c){
			colorDeFondo = c;
		}
		public void actionPerformed(ActionEvent e){
			setBackground(colorDeFondo);
		}
		private Color colorDeFondo;
	}
}