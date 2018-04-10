package poo;

public class Pruebas {

	public static void main(String[] args) {
		Empleados trabajador1 = new Empleados("Paco");
		Empleados trabajador2 = new Empleados("Ana");
		Empleados trabajador3 = new Empleados("Antonio");
		Empleados trabajador4 = new Empleados("María");
		
		trabajador1.cambiaSeccion("RRHH");
		
		System.out.println(trabajador1.devuelveDatos() + "\n" +
						trabajador2.devuelveDatos() + "\n" +
						trabajador3.devuelveDatos() + "\n" +
						trabajador4.devuelveDatos());
		System.out.println(Empleados.dameIdSiguiente());
	}

}

class Empleados{
	public Empleados(String nom){
		nombre = nom;
		seccion = "Adminitración";
		Id = IdSiguiente;
		IdSiguiente++;
	}
	public void cambiaSeccion(String seccion){//setter
		this.seccion = seccion;
	}
	public String devuelveDatos(){
		return "El nombre es " + nombre +
				" la sección es " + seccion +
				" y el Id=" + Id;
	}
	public static String dameIdSiguiente(){
		return "El IdSiguiente es " + IdSiguiente;
	}

	private final String nombre;//indica que el nombre es una constante que no se puede cambiar
	private String seccion;
	private int Id;
	private static int IdSiguiente=1;//indica que esta variable pertenece a la clase "Empleados" y no a un objeto
}