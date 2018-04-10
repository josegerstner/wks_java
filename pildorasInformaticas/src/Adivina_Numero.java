import java.util.*;
import javax.swing.*;
public class Adivina_Numero {

	public static void main(String[] args) {
		int aleatorio = (int) (Math.random()*100);
		Scanner entrada = new Scanner(System.in);
		int numero = 0;
		int intentos = 0;
		
		do{
			intentos++;
			System.out.println("Introduzca un n�mero");
			numero = entrada.nextInt();
			
			if(aleatorio < numero){
				System.out.println("Ingrese un n�mero m�s bajo");
			}
			else if(aleatorio > numero){
				System.out.println("Ingrese un n�mero m�s alto");
			}
			
		}while(numero != aleatorio);
		System.out.println("Correcto! Lo has conseguido en " + intentos + " intentos.");
		
	}

}
