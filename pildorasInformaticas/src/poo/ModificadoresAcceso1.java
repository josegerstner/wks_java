package poo;

public class ModificadoresAcceso1 {
	protected int mivar = 5; //El modificador de acceso "protected" deja acceder desde otro paquete
	protected int mivar2 = 7;
	protected String mimetodo(){
		return "El valor de mivar2 = " + mivar2;
	}
}
