import javax.swing.JOptionPane;

public class Entrada_de_datos_II {

	public static void main(String[] args) {
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		String edad = JOptionPane.showInputDialog("Introduce tu edad");
		int edad_user = Integer.parseInt(edad);
		System.out.println("Hola " + nombre + ". El año que viene tendrás " + (edad_user+1) + " años.");

	}

}
