package discoduroderoer;
import java.util.Scanner;
public class Operaciones {
	public static void main(String[] args) {
		int num1, num2;
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.printf("Ingrese un n�mero: ");
		num1 = entrada.nextInt();
		System.out.printf("Ingrese otro n�mero: ");
		num2 = entrada.nextInt();
		System.out.println("La suma de los n�meros es: " + suma(num1, num2));
		System.out.println("La resta de los n�meros es: " + resta(num1, num2));
		System.out.println("La multiplicaci�n de los n�meros es: " + multiplicacion(num1, num2));
		System.out.println("La divisi�n de los n�meros es: " + division(num1, num2));
		System.out.println("El m�dulo de los n�meros es: " + modulo(num1, num2));
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
