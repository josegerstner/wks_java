package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {
	public static void main(String[] args) {
		Persona[] lasPersonas = new Persona[2];
		lasPersonas[0] = new Empleado2("Luis Conde", 50000, 2009, 2, 25);
		lasPersonas[1] = new Alumno("Ana L�pez", "Biol�gicas");
		
		for(Persona p: lasPersonas){
			System.out.println(p.dameNombre() + ", " + p.dameDescripcion());
		}
	}

}

abstract class Persona{ //la clase Persona debe ser abstracta porque lleva uno o m�s m�todos abstractos
	public Persona(String nombre){//constructor
		this.nombre = nombre;
	}
	public String dameNombre(){//getter
		return nombre;
	}
	public abstract String dameDescripcion();//getter //m�todo abstracto porque todos lo tienen pero es diferente para todos	
	private String nombre;
}

class Empleado2 extends Persona{
	public Empleado2(String nom, double sue, int agno, int mes, int dia){
		super(nom);
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);//La clase GregorianCalendar est� en el paquete java.util, toma a Enero=0 por eso le restamos 1
		altaContrato = calendario.getTime();
		++IdSiguiente;
		Id=IdSiguiente;
	}
	public String dameDescripcion(){
		return "Este empleado tiene un Id = " + Id +
				" y un sueldo = " + sueldo;
	}
	public final double dameSueldo(){//getter //con final quiero decir que ese m�todo es definitivo, no se puede cambiar
		return sueldo;
	}
	public Date dameFechaContrato(){//getter
		return altaContrato;
	}
	public void subeSueldo(double porcentaje){//setter
		double aumento = sueldo*porcentaje/100;
		sueldo += aumento; 
	}	
	private double sueldo;
	private Date altaContrato;//La clase Date que estamos usando est� en el paquete java.util
	private static int IdSiguiente;
	private int Id;
}
class Alumno extends Persona{
	public Alumno(String nombre, String carrera){
		super(nombre);
		this.carrera = carrera;
	}
	public String dameDescripcion(){
		return "Este alumno est� estudiando la carrera de " + carrera;
	}
	private String carrera;
}