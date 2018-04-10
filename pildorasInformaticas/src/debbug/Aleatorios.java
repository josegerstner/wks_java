package debbug;

import javax.swing.JOptionPane;

public class Aleatorios {
	public static void main(String[] args) {
		int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz"));
		int numAleatorios[] = new int[elementos];
		
		for(int i=0; i<numAleatorios.length; i++){
			numAleatorios[i] = (int)Math.random()*100;
		}
		
		for(int elem: numAleatorios){
			System.out.println(elem);
		}
	}
}
