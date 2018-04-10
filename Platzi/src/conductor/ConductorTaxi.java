package conductor;
import vehiculo.Taxi;

public class ConductorTaxi extends Conductor{
	public ConductorTaxi(String nombre, String tipoLicencia, Taxi taxi) {
		super(nombre, tipoLicencia);
		this.setTaxi(taxi);
	}
	public Taxi getTaxi() {
		return taxi;
	}
	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	@Override
	public void mostrarVehiculo(){
		super.mostrarVehiculo();
		System.out.println(getTaxi().getMatricula());
	}
	
	private Taxi taxi;
	
}
