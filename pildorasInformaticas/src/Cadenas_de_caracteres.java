
public class Cadenas_de_caracteres {

	public static void main(String[] args) {
		// Clase String
		String mi_nombre = "José";
		String mi_nom2 = "jOsÉ";
		System.out.println("Mi nombre es " + mi_nombre);
		System.out.println("Mi nombre tiene " + mi_nombre.length() + " letras");
		System.out.println("La primera letra de " + mi_nombre + " es la " + mi_nombre.charAt(0));
		int ultima_letra = mi_nombre.length();
		System.out.println("La última letra de " + mi_nombre + " es la " + mi_nombre.charAt(ultima_letra-1));
		System.out.println(mi_nombre.substring(1,3));
		System.out.println(mi_nombre.equals(mi_nom2));
		System.out.println(mi_nombre.equalsIgnoreCase(mi_nom2));
		
		String frase = "Hoy es un estupendo día para aprender a programar en Java";
		System.out.println(frase.substring(29));
		System.out.println(frase.substring(29, frase.length()));
		
		String frase_resumen = frase.substring(0, 28) + " irnos a la playa y olvidarnos de todo..." + " y " +
				frase.substring(29, frase.length());
		System.out.println(frase_resumen);
		
	}

}
