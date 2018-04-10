package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDatos {
	public static void main(String[] args) {
		System.out.println("¿Qué deseas hacer?");
		System.out.println("1. Introducir datos.");
		System.out.println("2. Salir del programa.");
		
		Scanner entrada = new Scanner(System.in);
		int decision = entrada.nextInt();
		
		if(decision == 1){
			try{
				pedirDatos();
			}catch(InputMismatchException e){
				System.out.println("¿Qué demonios has intoducido en la edad?");
			}
		}else{
			System.out.println("Adiós");
			System.exit(0);
		}
		entrada.close();
	}
	static void pedirDatos() throws InputMismatchException{
		//No tiene sentido que el método que lance la excepción la capture desde dentro
		//try{
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduce tu nombre: ");
			String nombre = entrada.nextLine();
			System.out.println("Introduce tu edad: ");
			int edad = entrada.nextInt();
			System.out.println("Hola " + nombre + ". Tienes " + edad + " años.");
			entrada.close();
		//}catch(Exception e){
			//System.out.println("¿Qué demonios has intoducido en la edad?");
		//}
		
		System.out.println("Hemos terminado");
	}
}
