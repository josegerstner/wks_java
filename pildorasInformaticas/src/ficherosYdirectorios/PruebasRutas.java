package ficherosYdirectorios;

import java.io.File;

public class PruebasRutas {
	public static void main(String[] args) {
		File archivo = new File("archivoDeEjemplo");
		System.out.println(archivo.getAbsolutePath());
		System.out.println(archivo.exists());
	}
}
