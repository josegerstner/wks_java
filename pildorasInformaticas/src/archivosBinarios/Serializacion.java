package archivosBinarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializacion {
	public static void main(String[] args) {
		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
		jefe.setIncentivo(5000);
		
		Empleado[] personal = new Empleado[3];
		personal[0] = jefe;
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);
		
		try{
			//GUARDAMOS EL OBJETO 'personal' EN EL DISCO
			ObjectOutputStream guardarObjeto = new ObjectOutputStream(new FileOutputStream("/home/jose/workspace/pildorasInformaticas/src/archivosBinarios/Serializacion.dat"));
			guardarObjeto.writeObject(personal);
			guardarObjeto.close();
			
			//RESCATAMOS EL OBJETO 'personal' DEL DISCO
			ObjectInputStream traerObjeto = new ObjectInputStream(new FileInputStream("/home/jose/workspace/pildorasInformaticas/src/archivosBinarios/Serializacion.dat"));
			Empleado[] personalRecuperado = (Empleado[]) traerObjeto.readObject();
			traerObjeto.close();
			for(Empleado e: personalRecuperado){
				System.out.println(e);
			}
		}catch(Exception e){
			System.out.println("No se ha podido crear el fichero");
		}
	}
}

class Empleado implements Serializable{
	private static final long serialVersionUID = 1L;
	public Empleado(String nombre, double sueldo, int anio, int mes, int dia){
		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes, dia);
		fechaContrato = calendario.getTime();
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void subirSueldo(double porcentaje){
		double aumento = sueldo * porcentaje /100;
		sueldo += aumento;
	}
	public String toString(){
		return "Nombre=" + nombre + ", sueldo=" + sueldo + ", fecha de contrato=" + fechaContrato;
	}
	private String nombre;
	private double sueldo;
	private Date fechaContrato;
}

class Administrador extends Empleado{
	private static final long serialVersionUID = 1L;
	public Administrador(String nombre, double sueldo, int anio, int mes, int dia){
		super(nombre, sueldo, anio, mes, dia);
		incentivo = 0;
	}
	public double getIncentivo(){
		double sueldoBase = super.getSueldo();
		return sueldoBase + incentivo;
	}
	public void setIncentivo(double incentivo){
		this.incentivo = incentivo;
	}
	public String toString(){
		return super.toString() + ", incentivo=" + incentivo;
	}
	private double incentivo;
}