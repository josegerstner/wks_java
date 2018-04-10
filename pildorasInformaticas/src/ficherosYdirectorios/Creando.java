package ficherosYdirectorios;

import java.io.File;
import java.io.FileWriter;

public class Creando {
	public static void main(String[] args) {
		//intanciamos un File
		File ruta = new File(File.separator + "home" + File.separator + "jose" + File.separator + "workspace" + File.separator + "pildorasInformaticas" + File.separator + "src" + File.separator + "ficherosYdirectorios" + File.separator + "nuevoDirectorio");
		//creamos el directorio
		ruta.mkdir();
		
		//instanciamos un File
		File archivo = new File(File.separator + "home" + File.separator + "jose" + File.separator + "workspace" + File.separator + "pildorasInformaticas" + File.separator + "src" + File.separator + "ficherosYdirectorios" + File.separator + "nuevoArchivo.txt");
		try{
			//creamos el archivo si no existe
			archivo.createNewFile();
		}catch(Exception e){
			System.out.println("No se ha podido crear el archivo");
		}
		
		//escribimos en un archivo existente
		String archivoDestino = archivo.getAbsolutePath();
		Escribiendo escritor = new Escribiendo();
		escritor.escribir(archivoDestino);
	}
}
class Escribiendo{
	public void escribir(String rutaArchivo){
		String frase = "La concha de tu madre All Boys";
		try{
			FileWriter escritura = new FileWriter(rutaArchivo);
			for(int i=0; i<frase.length(); i++){
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		}catch(Exception e){
			System.out.println("No se puede escribir el archivo");
		}
	}
}