package garbagecollector;

public class Persona {
	private String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected void finalize() throws Throwable {
		super.finalize();
	}
}
