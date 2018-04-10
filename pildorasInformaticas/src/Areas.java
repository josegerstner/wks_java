import java.util.Scanner;
import javax.swing.JOptionPane;
public class Areas {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige una opci�n: \n\t1: Cuadrado \n\t2: Rect�ngulo \n\t3: Tri�ngulo \n\t4: C�rculo");
		int figura = entrada.nextInt();
		switch(figura){
		case 1:
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el lado"));
			System.out.println("El �rea del cuadrado es: " + Math.pow(lado, 2));
			break;
		case 2:
			int base = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la base"));
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la altura"));
			System.out.println("El �rea del rect�ngulo es: " + base*altura);
			break;
		case 3:
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la base"));
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la altura"));
			System.out.println("El �rea del tri�ngulo es: " + (base*altura)/2);
			break;
		case 4:
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el radio"));
			System.out.print("El �rea del tri�ngulo es: ");
			System.out.printf("%1.2f", Math.PI*Math.pow(radio,2));
			break;
		default:
			System.out.println("La opci�n no es correcta");
		}

	}

}