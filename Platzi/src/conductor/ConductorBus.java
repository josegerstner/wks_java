package conductor;

import vehiculo.Bus;

public class ConductorBus extends Conductor{
	public ConductorBus(String nombre, String tipoLicencia, Bus bus) {
		super(nombre, tipoLicencia);
		this.setBus(bus);
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	@Override
	public void mostrarVehiculo() {
		super.mostrarVehiculo();
		System.out.println(getBus().getMarca());
	}

	private Bus bus;
}
