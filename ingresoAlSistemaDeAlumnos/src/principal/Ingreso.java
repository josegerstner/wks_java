package principal;
import javax.swing.JOptionPane;
public class Ingreso {

	public static void main(String[] args) {
		 final String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		 final String apellido = JOptionPane.showInputDialog("Ingrese su apellido");
		 System.out.println("Nombre: " + nombre +
				 			"\nApellido: " + apellido);
		 
	}

}
