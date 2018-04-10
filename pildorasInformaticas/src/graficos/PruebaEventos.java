package graficos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
public class PruebaEventos {
	public static void main(String[] args) {
		MarcoConBoton mimarco = new MarcoConBoton();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConBoton extends JFrame{
	public MarcoConBoton(){
		setTitle("Botones y eventos");
		setSize(400,400);
		LaminaConBoton miLamina = new LaminaConBoton();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class LaminaConBoton extends JPanel implements ActionListener{//debe implementar la interfaz ActionListener porque es la lámina la que va a recibir el evento
	JButton botonAzul = new JButton("Azul");//creamos un botón al que llamamos botonAzul con un texto en su interior("Azul")
	JButton botonVerde = new JButton("Verde");
	JButton botonRojo = new JButton("Rojo");
	
	public LaminaConBoton(){
		add(botonAzul);//añadimos el botón a la lámina
		add(botonVerde);
		add(botonRojo);
		
		botonAzul.addActionListener(this);//le decimos quién va a ser el Listener del evento
		botonVerde.addActionListener(this);
		botonRojo.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		Object botonPulsado = e.getSource();
		if(botonPulsado == botonAzul){
			setBackground(Color.BLUE);
		}
		if(botonPulsado == botonVerde){
			setBackground(Color.GREEN);
		}
		if(botonPulsado == botonRojo){
			setBackground(Color.RED);
		}
	}
}