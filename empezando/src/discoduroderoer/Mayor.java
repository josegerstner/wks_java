package discoduroderoer;
import javax.swing.JOptionPane;
public class Mayor {
	public static void main(String[] args) {
		int num1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número"));
		int num2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese otro número"));
		JOptionPane.showMessageDialog(null, esMayor(num1, num2));
	}
	private static String esMayor(final int x, final int y){
		if(x>y){
			return "El primer número es mayor";
		}else if(x<y){
			return "El segundo número es mayor";
		}else{
			return "Los números sin iguales";
		}
	}
}
