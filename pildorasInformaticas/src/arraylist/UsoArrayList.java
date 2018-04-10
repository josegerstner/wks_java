package arraylist;

import java.io.File;

public class UsoArrayList {
	public static void main(String[] args) {
		ArrayList archivos = new ArrayList(4);
		
		/*
		archivos.add("Juan");
		archivos.add("María");
		archivos.add("Ana");
		archivos.add("Sandra");
		
		String nombrePersona = (String)archivos.get(1);
		System.out.println(nombrePersona);
		*/
		
		archivos.add(new File("GestionPedidos.accdb"));
		
		File nombreArchivo = (File)archivos.get(0);
		System.out.println(nombreArchivo);
	}
}
