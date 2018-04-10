package excepciones;

import javax.swing.JOptionPane;

public class VariasExcepciones {
	public static void main(String[] args) {
		try{
			division();
		}catch(ArithmeticException e){
			System.out.println("Se a dividido por cero");
			System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}catch(NumberFormatException e){
			System.out.println("Sólo se permite el ingreso de números enteros");
			System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
		
	}
	static void division(){
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dividendo"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el divisor"));
		
		System.out.println("El resultado es " + num1/num2);
	}
}
