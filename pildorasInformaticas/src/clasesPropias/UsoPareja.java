package clasesPropias;

public class UsoPareja {
	public static void main(String[] args) {
		Pareja<String> una = new Pareja<String>();
		una.setPrimero("Pedro");
		System.out.println(una.getPrimero());
		
		Persona girl = new Persona("Ana");
		Pareja<Persona> otra = new Pareja<Persona>();
		otra.setPrimero(girl);
		System.out.println(otra.getPrimero());
		
	}
}

class Persona{
	public Persona(String nombre){
		this.nombre = nombre;
	}
	public String toString(){
		return nombre;
	}
	private String nombre;
}