package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {
	public static void main(String[] args) {
		
		/*Empleado listaEmpleados[] = new Empleado[3];
		listaEmpleados[0] = new Empleado("Ana", 45, 2500);
		listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
		listaEmpleados[2] = new Empleado("María", 25, 2600);*/
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		//podemos indicarle cuántos elemento va a tener
		//listaEmpleados.ensureCapacity(3);
		
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("María", 25, 2600));
		listaEmpleados.add(new Empleado("Pedro", 35, 2700));
		listaEmpleados.add(new Empleado("Mónica", 21, 2100));
		
		//preguntamos qué hay en la posición 3
		System.out.println(listaEmpleados.get(3).dameDatos());
		
		//sobreescribimos el dato de la posición 3 con un nuevo elemento
		listaEmpleados.set(3, new Empleado("Laura", 22, 2200));
		
		//cerramos el ingreso de datos para liberar memoria
		listaEmpleados.trimToSize();
		
		//nos devuelve la cantidad de elementos que contiene
		System.out.println(listaEmpleados.size());
		
		//utilizamos la interfaz Iterator para recorrer un arrayList
		//para esto debemos inicializarlo como el array que quiero recorrer
		//y su método iterator quien lo recorre
		Iterator<Empleado> miIterador = listaEmpleados.iterator();
		
		//de esta manera recorremos el arrayList
		while(miIterador.hasNext()){
			System.out.println(miIterador.next().dameDatos());
		}
		
		/*for(Empleado e: listaEmpleados){
			System.out.println(e.dameDatos());
		}*/
		
		//podemos usar un for convencional para el caso pero utilizando otros métodos
		/*for(int i=0; i<listaEmpleados.size(); i++){
			System.out.println(listaEmpleados.get(i).dameDatos());
		}*/
	}
}
class Empleado{
	public Empleado(String nombre, int edad, double salario){
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	public String dameDatos() {
		return "El empleado se llama " + nombre + ". Tiene "+ edad + " años. Y un salario de " + salario;
	}
	private String nombre;
	private int edad;
	private double salario;
}