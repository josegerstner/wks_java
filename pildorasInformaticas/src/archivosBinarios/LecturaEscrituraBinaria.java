package archivosBinarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturaEscrituraBinaria {
	public static void main(String[] args) {
		int contador = 0;
		int[] datosEntrada = new int[49923];//el número es la cantidad de bytes de la imagen
		try {
			FileInputStream lectura = new FileInputStream("/home/jose/workspace/pildorasInformaticas/src/archivosBinarios/pikawaii.png");
			boolean finalArchivo = false;
			
			while(!finalArchivo){
				int byteEntrada = lectura.read();
				
				if(byteEntrada != -1){//el -1 no forma parte de la imagen
					datosEntrada[contador] = byteEntrada;
				}else{
					finalArchivo = true;
				}
				System.out.println(datosEntrada[contador]);
				contador++;
			}
			lectura.close();
		} catch (IOException e) {
			System.out.println("El fichero no ha sido encontrado");
		}
		System.out.println(contador);
		creaFichero(datosEntrada);
	}
	static void creaFichero(int datosNuevoFichero[]){
		try{
			FileOutputStream ficheroNuevo = new FileOutputStream("/home/jose/workspace/pildorasInformaticas/src/archivosBinarios/piCopiachu.png");
			for(int i=0; i<datosNuevoFichero.length; i++){
				ficheroNuevo.write(datosNuevoFichero[i]);
			}
			ficheroNuevo.close();
		}catch(IOException e){
			System.out.println("Hubo error al crear el fichero");
		}
	}
}
