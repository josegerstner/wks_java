import javax.swing.*;
public class Uso_arrays_II_con_FOREACH {

	public static void main(String[] args) {
		String[] paises = new String [8];
		//Una forma de inicializar
		/*paises[0]="Espa�a";
		paises[1]="M�xico";
		paises[2]="Colombia";
		paises[3]="Per�";
		paises[4]="Chile";
		paises[5]="Argentina";
		paises[6]="Ecuador";
		paises[7]="Venezuela";*/
		//Otra forma de inicializar
		//String[] paises = {"Espa�a", "M�xico", "Colombia", "Per�", "Chile", "Argentina", "Ecuador", "Venezuela"};
		//Otra forma de inicializar la matriz pero con JOptionPane
		for(int i=0; i<8; i++){
			paises[i] = JOptionPane.showInputDialog("Introduzca un pa�s " + (i+1));
		}
		
		/*for(int i=0; i<paises.length; i++){
			System.out.println("Pa�s " + (i+1) + ": " + paises[i]);
		}*/
		for(String elemento: paises){
			System.out.println("Pa�s: " + elemento);
		}
	}

}
