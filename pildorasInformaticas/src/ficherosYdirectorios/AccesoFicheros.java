package ficherosYdirectorios;

import java.io.File;

public class AccesoFicheros {
	public static void main(String[] args) {
		File ruta = new File("/home/jose/workspace/pildorasInformaticas/src/ficherosYdirectorios/");
		System.out.println(ruta.getAbsolutePath());
		
		String[] nombresArchivos = ruta.list(); //devuelve la lista de archivos en el directorio del File ruta
		for(String e: nombresArchivos){
			System.out.println(e);
			//instanciamos un file con cada nombre recorrido
			File f = new File(ruta.getAbsolutePath(), e);
			//preguntamos si el nombre recorrido es un directorio
			if(f.isDirectory()){
				//si lo es, vemos qué archivos tiene
				String[] archivosSubcarpeta = f.list();
				//y los imprimimos
				for(String x: archivosSubcarpeta){
					System.out.println(x);
				}
			}
		}
	}
}
