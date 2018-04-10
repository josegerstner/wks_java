package discoduroderoer;
import javax.swing.JOptionPane;
public class CaracteresASCII {
	public static void main(String[] args) {
		char letra = 0;
		int opcion;
		int num;
		do{
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Qué desea hacer?\n1 - Ingresar código ASCII\n2 - Ingresar caracter\n0 - Salir"));
			if(opcion == 1){
				num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código ASCII"));
				letra = (char) num;
				JOptionPane.showMessageDialog(null, "El caracter del código ingresado es: " + letra);
			}
			if(opcion == 2){
				letra = JOptionPane.showInputDialog("Ingrese un caracter").charAt(0);
				num = (int) letra;
				JOptionPane.showMessageDialog(null, "El código del caracter ingresado es: " + num);
			}
			if(opcion >= 3){
				JOptionPane.showMessageDialog(null, "ERROR: Opción incorrecta");
			}
		}while(opcion != 0);
	}
}
