import javax.swing.*;
public class Acceso_aplicacion {

	public static void main(String[] args) {
		String clave = "Jos�";
		String pass = ""; 
		
		while(clave.equals(pass) == false){
			pass = JOptionPane.showInputDialog("Introduzca la contrase�a");
			if(clave.equals(pass) == false){
				System.out.println("Contrase�a incorrecta");
			}
		}
		System.out.println("Contrase�a correcta. Acceso permitido.");
	}

}
