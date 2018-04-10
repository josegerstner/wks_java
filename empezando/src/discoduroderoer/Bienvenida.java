package discoduroderoer;
import javax.swing.JOptionPane;
public class Bienvenida {
	public static void main(String[] args) {
		String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		JOptionPane.showMessageDialog(null, "Bienvenido " + nombre);
	}
}
