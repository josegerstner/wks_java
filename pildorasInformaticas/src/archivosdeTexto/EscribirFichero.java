package archivosdeTexto;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
	public static void main(String[] args) {
		Escribiendo escritor = new Escribiendo();
		escritor.escribir();
	}
}
class Escribiendo{
	public void escribir(){
		String frase = "Esto es una prueba de escritura :D";
		try {
			FileWriter escritura = new FileWriter("/home/jose/workspace/pildorasInformaticas/src/archivos_leyendo/EscribirFichero.txt", false);
			for(int i=0; i<frase.length(); i++){
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero");
		}
	}
}