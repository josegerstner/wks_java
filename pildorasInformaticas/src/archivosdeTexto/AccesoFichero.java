package archivosdeTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccesoFichero {
	public static void main(String[] args) {
		LeerFichero accediendo = new LeerFichero();
		accediendo.leer();
	}
}
class LeerFichero{
	public void leer(){
		try {
			FileReader entrada = new FileReader("/home/jose/workspace/pildorasInformaticas/src/archivos_leyendo/AccesoFichero.txt");
			BufferedReader miBuffer = new BufferedReader(entrada);
			String linea = "";
			
			//Ejemplo leyendo caracter a caracter
			//int c = 0;
			// El método read me devuelve '-1' cuando terminó de leer el archivo
			//while(c!=-1){
				//c = entrada.read();
				//char letra=(char)c;
				//if(c!=-1)
					//System.out.print(letra);
			
			//Ejemplo leyendo línea a línea
			while(linea != null){
				linea = miBuffer.readLine();
				if(linea != null)
					System.out.println(linea);
			}
			entrada.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo.");
		}
	}
}