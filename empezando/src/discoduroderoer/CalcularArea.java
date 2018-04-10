package discoduroderoer;
import javax.swing.JOptionPane;
public class CalcularArea {
	public static void main(String[] args) {
		double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio"));
		JOptionPane.showMessageDialog(null, "El área es: " + area(radio));
	}
	private static double area(double x){
		return (Math.PI*Math.pow(x, 2));
	}
}
