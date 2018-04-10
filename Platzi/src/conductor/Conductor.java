package conductor;

public class Conductor {
	private String nombre;
	private String tipoLicencia;
	
	public Conductor(String nombre, String tipoLicencia) {
		super();
		this.nombre = nombre;
		this.tipoLicencia = tipoLicencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoLicencia() {
		return tipoLicencia;
	}
	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}
	public void mostrarVehiculo(){
		System.out.println("Datos vehículo: ");
	}
	
}
