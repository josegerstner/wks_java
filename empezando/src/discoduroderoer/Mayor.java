package discoduroderoer;
import javax.swing.JOptionPane;
public class Mayor {
	public static void main(String[] args) {
		int num1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un n�mero"));
		int num2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese otro n�mero"));
		JOptionPane.showMessageDialog(null, esMayor(num1, num2));
	}
	private static String esMayor(final int x, final int y){
		if(x>y){
			return "El primer n�mero es mayor";
		}else if(x<y){
			return "El segundo n�mero es mayor";
		}else{
			return "Los n�meros sin iguales";
		}
	}
}
