import javax.swing.*;
public class Entrada_numeros {

	public static void main(String[] args) {
		/*
		 * double x = 1000.0;
		 * System.out.println(x/3);
		 * System.out.printf("%1.2f", x/3); // 
		 * con printf lo que hacemos es imprimir con "formato"
		 * */
		String num1 = JOptionPane.showInputDialog("Introduce un n�mero");
		double num2 = Double.parseDouble(num1);
		System.out.print("La ra�z de  " + num2 + " es ");
		System.out.printf("%1.2f", Math.sqrt(num2));
	}

}
