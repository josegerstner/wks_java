package excepciones;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class FinallyExample {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige una opción: \n\t1 - Cuadrado\n\t2 - Rectángulo\n\t3 - Triángulo\n\t4 - Círuclo");
		try{
			figura = entrada.nextInt();
		}catch(Exception e){
			
		}finally{//la sentencia finally indica que siempre se ejecurará el proceso que se encuentre dentro
			entrada.close();
		}
		
		switch(figura){
		case 1:
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			System.out.println("El área del cuadrado es: " + Math.pow(lado, 2));
			break;
		case 2:
			int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			System.out.println("El área del rectángulo es: " + base*altura);
			break;
		case 3:
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			System.out.println("El área del triángulo es: " + (base*altura)/2);
			break;
		case 4:
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
			System.out.println("El área del círulo es " + Math.PI*(Math.pow(radio, 2)));
			break;
		default:
			System.out.println("La opción no es correcta");
		}
		//------------------------------------------------------------------------------------------
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
		System.out.println("Si eres hombre tu peso ideal es: " + (altura - 110) + " kg");
		System.out.println("Si eres mujer tu peso ideal es: " + (altura - 120) + " kg");
	}
	public static int figura;
}
