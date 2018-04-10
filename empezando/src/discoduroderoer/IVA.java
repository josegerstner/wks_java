package discoduroderoer;
import javax.swing.JOptionPane;
public class IVA {
	public static void main(String[] args) {
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese un precio"));
		JOptionPane.showMessageDialog(null, "El precio es: " + calcular(precio));
	}
	private static double calcular(double p){
		return p+p*IVA/100;
	}
	private static int IVA = 21;
}
