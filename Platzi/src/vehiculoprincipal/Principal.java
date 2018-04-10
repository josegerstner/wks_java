package vehiculoprincipal;

import java.util.ArrayList;

import vehiculo.Vehiculo;

public class Principal {
	public static void main(String[] args) {
		Vehiculo miVehiculo = new Vehiculo("AAA123", "Hiundai");
		
		/*miVehiculo.arrancar();
		miVehiculo.frenar();
		miVehiculo.reversa();*/
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(miVehiculo);
		vehiculos.add(new Vehiculo("BBB123", "Chevrolet"));
		vehiculos.add(new Vehiculo("CCC123", "Ford", "Focus", 2017));
		for(Vehiculo vehiculo: vehiculos){
			System.out.println(vehiculo.getMatricula());
			System.out.println(vehiculo.getMarca());
			System.out.println(vehiculo.getModelo());
			System.out.println(vehiculo.getAnio());
		}
	}
}
