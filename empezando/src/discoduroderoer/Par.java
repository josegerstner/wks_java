package discoduroderoer;
import javax.swing.JOptionPane;
public class Par {
	public static void main(String[] args) {
		int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número"));
		JOptionPane.showMessageDialog(null, "El valor " + paridad(num));
	}
	private static String paridad(final int num){
		if(num%2 == 0){
			return "es par";
		}else{
			return "no es par";
		}
	}
}
