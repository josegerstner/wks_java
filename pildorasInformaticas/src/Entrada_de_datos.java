import java.util.*;
public class Entrada_de_datos {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		String nombre_usuario = entrada.nextLine();
		System.out.println("Introduce tu edad: ");
		int edad = entrada.nextInt();
		System.out.println("Hola " + nombre_usuario + ". El a�o que viene tendr�s " + (edad+1) + " a�os.");
	}

}
