package discoduroderoer;
import java.util.Scanner;
public class Operaciones {
	public static void main(String[] args) {
		int num1, num2;
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.printf("Ingrese un número: ");
		num1 = entrada.nextInt();
		System.out.printf("Ingrese otro número: ");
		num2 = entrada.nextInt();
		System.out.println("La suma de los números es: " + suma(num1, num2));
		System.out.println("La resta de los números es: " + resta(num1, num2));
		System.out.println("La multiplicación de los números es: " + multiplicacion(num1, num2));
		System.out.println("La división de los números es: " + division(num1, num2));
		System.out.println("El módulo de los números es: " + modulo(num1, num2));
	}
	private static int suma(final int x, final int y){
		return  x + y;
	}
	private static int resta(final int x, final int y){
		return x - y;
	}
	private static int multiplicacion(final int x, final int y){
		return x * y;
	}
	private static double division(final int x, final int y){
		return (double)x / (double)y;
	}
	private static int modulo(final int x, final int y){
		return x % y;
	}
}
