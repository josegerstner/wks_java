package poo;
import paquetePruebas.*;
public class ModificadoresAcceso2 {

	public static void main(String[] args) {
		ModificadoresAcceso1 miobj = new ModificadoresAcceso1();
		ModificadoresAcceso3 miobj2 = new ModificadoresAcceso3();
		System.out.println(miobj2.mimetodo());
	}

}
