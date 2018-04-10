package poo;
import java.util.*;
public class Uso_empleado {

	public static void main(String[] args) {
		/*Empleado empleado1 = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		Empleado empleado2 = new Empleado("Ana López", 95000, 1995, 6, 2);
		Empleado empleado3 = new Empleado("María Martín", 105000, 2002, 3, 15);
		
		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		
		System.out.println("Nombre: " + empleado1.dameNombre() + " Sueldo: " + empleado1.dameSueldo()
					+ " Fecha de Alta: " + empleado1.dameFechaContrato());
		System.out.println("Nombre: " + empleado2.dameNombre() + " Sueldo: " + empleado2.dameSueldo()
					+ " Fecha de Alta: " + empleado2.dameFechaContrato());
		System.out.println("Nombre: " + empleado3.dameNombre() + " Sueldo: " + empleado3.dameSueldo()
					+ " Fecha de Alta: " + empleado3.dameFechaContrato());*/
		Jefatura jefe_RRHH = new Jefatura("Pedro", 55000, 2006, 9, 25);
		jefe_RRHH.estableceIncentivo(2570);
		
		
		Empleado[] misEmpleados = new Empleado[6];
		misEmpleados[0] = new Empleado("Paco", 85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("Ana", 95000, 1995, 6, 2);
		misEmpleados[2] = new Empleado("Carlos", 105000, 2002, 3, 15);
		misEmpleados[3] = new Empleado("Antonio");
		
		misEmpleados[4] = jefe_RRHH; //Polimorfismo en acción- Principio de sustitución
		misEmpleados[5] = new Jefatura("María", 95000, 1999,5,26);
		
		Jefatura jefa_finanzas = (Jefatura) misEmpleados[5];//Casting de un objeto
		jefa_finanzas.estableceIncentivo(55000);
		
		System.out.println(jefa_finanzas.tomarDecisiones("Dar más días de vacaciones a los empleados"));
		
		System.out.println("El jefe " + jefa_finanzas.dameNombre() + " tiene un bonus de " + jefa_finanzas.estableceBonus(500));
		System.out.println(misEmpleados[3].dameNombre() + " tiene un bonus de " + misEmpleados[3].estableceBonus(200));
		/*
		 Empleado director_comercial = new Jefatura("Sandra", 85000, 2012, 05, 05);
		 Comparable ejemplo = new Empleado("Elisabeth", 95000, 2011, 06, 07);
		if(director_comercial instanceof Empleado){
			System.out.println("Es del tipo Jefatura");
		}
		if(ejemplo instanceof Comparable){
			System.out.println("Es del tipo Comparable");
		}*/
		
		/*for(int i=0; i<misEmpleados.length; i++){
			misEmpleados[i].subeSueldo(5);
		}*/
		
		for(Empleado e: misEmpleados){//le aumento el sueldo a todos los empleados con un foreach
			e.subeSueldo(5);
		}
		
		Arrays.sort(misEmpleados);//ordeno misEmpleados según el método compareTo
		
		/*for(int i=0; i<misEmpleados.length; i++){
			System.out.println("Nombre: " + misEmpleados[i].dameNombre() 
							+ " Sueldo: " + misEmpleados[i].dameSueldo()
							+ " Fecha de Alta: " + misEmpleados[i].dameFechaContrato());
		}*/
		
		for(Empleado e: misEmpleados){//imprimo los datos de los empleados con un foreach 
			System.out.println("Nombre: " + e.dameNombre() 
					+ " Sueldo: " + e.dameSueldo()
					+ " Fecha de Alta: " + e.dameFechaContrato());
		}
		
	}

}

class Empleado implements Comparable, Trabajadores{//para poder ordenar, debo implementar la interface Comparable
	public Empleado(String nom, double sue, int agno, int mes, int dia){
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);//La clase GregorianCalendar está en el paquete java.util, toma a Enero=0 por eso le restamos 1
		altaContrato = calendario.getTime();
		++IdSiguiente;
		Id = IdSiguiente;
	}
	public Empleado(String nom){
		this(nom, 30000, 2000, 01, 01);
	}
	
	public double estableceBonus(double gratificacion){
		return Trabajadores.bonus_base + gratificacion;
	}
	public String dameNombre(){//getter
		return nombre + " Id:" + Id;
	}
	public final double dameSueldo(){//getter //con final quiero decir que ese método es definitivo, no se puede cambiar
		return sueldo;
	}
	public Date dameFechaContrato(){//getter
		return altaContrato;
	}
	public void subeSueldo(double porcentaje){//setter
		double aumento = sueldo*porcentaje/100;
		sueldo += aumento; 
	}
	public int compareTo(Object miObjeto){//debo implementar este método para poder usar sort
											//en este método le debo indicar qué utilizar para ordenar
		Empleado otroEmpleado = (Empleado) miObjeto;
		if(this.Id < otroEmpleado.Id){
			return -1;
		}
		else if(this.Id > otroEmpleado.Id){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;//La clase Date que estamos usando está en el paquete java.util
	private static int IdSiguiente;
	private int Id;
}
final class Jefatura extends Empleado implements Jefes{ // Al poner que la clase es "final" significa que nadie puede heredar de esa clase
	public Jefatura(String nom, double sue, int agno, int mes, int dia){//constructor
		super(nom, sue, agno, mes, dia);
	}
	public void estableceIncentivo(double b){//setter
		incentivo = b;
	}
	public double dameSueldo2(){//getter //tuve que cambiarle el nombre porque no puedo modificar un método final
		double sueldoJefe=super.dameSueldo();
		return sueldoJefe + incentivo;
	}
	public String tomarDecisiones(String decision){
		return "Un miembro de la dirección ha tomado la decisión de " + decision;
	}
	public double estableceBonus(double gratificacion){
		double prima = 2000;
		return Trabajadores.bonus_base + gratificacion + prima;
	}
	private double incentivo;
}
class Director extends Empleado{//No puede heredar de Jefatura
	public Director(String nom, double sue, int agno, int mes, int dia){//constructor
		super(nom, sue, agno, mes, dia);
	}
}