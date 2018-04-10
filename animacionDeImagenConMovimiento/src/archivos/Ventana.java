package archivos;
import javax.swing.JFrame;
@SuppressWarnings("serial")
public class Ventana extends JFrame {
	public Ventana(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Dibujar());//se incluye la clase dibujar
		setTitle("Crear animación de imagen");
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);//para que nuestra ventana se centre :D
		setResizable(false);
	}
	public static void main(String[] args) {
		new Ventana();
	}
}
