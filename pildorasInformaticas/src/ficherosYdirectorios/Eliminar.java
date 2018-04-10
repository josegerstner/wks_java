package ficherosYdirectorios;

import java.io.File;

public class Eliminar {
	public static void main(String[] args) {
		File archivo = new File(File.separator + "home" + File.separator + "jose" + File.separator + "workspace" + File.separator + "pildorasInformaticas" + File.separator + "src" + File.separator + "ficherosYdirectorios" + File.separator + "nuevoArchivo.txt");
		archivo.delete();
	}
}
