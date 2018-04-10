package poo;
import javax.swing.*;
public class Uso_Vehiculo {

	public static void main(String[] args) {
		
		/*Coche Renault = new Coche(); //INSTANCIAR UNA CLASE / EJEMPLARIZAR UNA CLASE
		//Renault.ruedas=3;
		//System.out.println("Este coche tiene: " + Renault.ruedas + " ruedas.");
		System.out.println(Renault.dime_datos_generales());
		Renault.estableceColor(JOptionPane.showInputDialog("Ingrese un color"));
		System.out.println(Renault.dimeColor());
		Renault.configura_asientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero?"));
		System.out.println(Renault.dime_asientos());
		Renault.configura_climatizador(JOptionPane.showInputDialog("¿Tiene climatizador?"));
		System.out.println(Renault.dime_climatizador());
		System.out.println(Renault.dime_peso_coche());
		System.out.println("El precio del coche es " + Renault.precio_coche());*/
		Coche miCoche1 = new Coche();
		miCoche1.estableceColor("Rojo");
		Furgoneta miFurgoneta1 = new Furgoneta(7, 580);
		miFurgoneta1.estableceColor("Azul");
		miFurgoneta1.configura_asientos("Si");
		miFurgoneta1.configura_climatizador("Si");
		System.out.println(miCoche1.dime_datos_generales() + " " + miCoche1.dimeColor());
		System.out.println(miFurgoneta1.dime_datos_generales() + " " + miFurgoneta1.dime_datos_furgoneta());
		
	}

}
