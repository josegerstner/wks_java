package clasesPropias;

public class HerenciaGenericos {
	public static void main(String[] args) {
		/*Empleado administrativa = new Empleado("Elena", 45, 1500);
		Jefe directoraComercial = new Jefe("Ana", 27, 3500);
		Empleado nuevoEmpleado = directoraComercial;*/
		
		Pareja<Empleado> administrativa = new Pareja<Empleado>();
		Pareja<Jefe> directoraComercial = new Pareja<Jefe>();
		
		//las clases genéricas no permiten transformar de una clase a la otra
		//aunque la clase herede de la otra clase
		//Pareja<Empleado> nuevoEmpleado = directoraComercial;
		
		Pareja.imprimirTrabajador(administrativa);
		Pareja.imprimirTrabajador(directoraComercial);
	}
}
