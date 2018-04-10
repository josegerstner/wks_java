package clasesPropias;

import java.util.GregorianCalendar;

public class MetodosGenericos {
	public static void main(String[] args) {
		
		String[] nombres = {"José", "María", "Roberto"};
		System.out.println(MisMatrices.getElementos(nombres));
		System.out.println("El menor es: " + MisMatrices.getMenor(nombres));
		
		Empleado[] empleados = {
				new Empleado("Ana", 45, 2300),
				new Empleado("Pedro", 35, 2400),
				new Empleado("José", 28, 2500),
				new Empleado("María", 22, 2600),
				new Empleado("Lorena", 20, 2700)
		};
		System.out.println(MisMatrices.getElementos(empleados));
		//no puedo utilizar el método getMenor en empleados porque no implementa la interfaz Comparable
		//System.out.println(MisMatrices.getMenor(empleados));
		
		GregorianCalendar fechas[] = {
				new GregorianCalendar(2015, 07, 02),
				new GregorianCalendar(2015, 03, 02),
				new GregorianCalendar(2015, 05, 02)
		};
		System.out.println(MisMatrices.getElementos(fechas));
		System.out.println("El menor es: " + MisMatrices.getMenor(fechas));
	}
}
class MisMatrices{
	//el TipoDeDatoADevolver es justamente eso, el tipo de dato que devuelve
	//mientras que el <T> es el argumento de tipo para hacerlo genérico
	public static <T> String getElementos(T[] array){
		return "El array tiene " + array.length + " elementos";
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable> T getMenor(T[] array){
		if(array==null || array.length==0){
			return null;
		}
		
		T menor = array[0];
		for(int i=1; i<array.length; i++){
			if(menor.compareTo(array[i])>0){
				menor = array[i];
			}
		}
		return menor;
	}
}