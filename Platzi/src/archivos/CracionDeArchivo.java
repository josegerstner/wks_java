/****************************************************************
 * FUJOS DE DATOS (Streams)
 * 
 * FLUJOS DE BYTES:
 * 		InputStream:
 * 			ByteArrayInputStream: lee un arreglo de bytes en memoria
 * 			FileInputStream: lee datos de un archivo
 * 			PipedInputStream: lee datos de otra parte del programa (otro thread)
 * 			Otros:
 * 				BufferedInputStream: lee más de un byte a la vez (más eficiente)
 * 				DataInputStream: lee tipos de datos primitivos
 * 				ObjectInputStream: lee objetos
 * 				PushbackInputStream: agrega datos adicionales al flujo de entrada
 * 				SequenceInputStream: concatena dos o más streams
 * 		OutputStream
 * 			ByteArrayOutputStream
 * 			FileOutputStream
 * 			PipedOutputStream
 * 			Otros:
 * 				BufferedOutputStream
 * 				DataOutputStream
 * 				ObjectOutputStream
 * 				PrintStream: escribe tipos de dato primitivo y cadenas a un flujo
 * 					 de salida y puede terminarlos con caracteres de nueva línea
 * 
 * FLUJOS DE CARACTERES:
 * 		Reader:
 * 			CharArrayReader: lee un arreglo de caracteres en memoria
 * 			FileReader: lee datos de un archivo
 * 			PipedReader: lee datos de otra parte del programa (otro thread)
 * 			StringReader: lee datos de una cadena en memoria
 * 			Otros:
 * 				BufferedReader: lee más de un caracter a la vez (más eficiente)
 * 				LineNumberReader: parecido a BufferedReader pero con control en
 * 					los números de línea
 * 				PushbackReader: agrega datos adicionales al flujo de entrada
 * 		Writer:
 * 			CharArrayReader: escribe un arreglo de caracteres en memoria
 * 			FileWriter: escribe datos en un archivo
 * 			PipedWriter
 * 			StringWriter: escribe datos a una cadena en memoria
 * 			Otros:
 * 				BufferedWriter: escribe más de un caracter (más eficaz)
 * 				PrintWriter: escribe tipos de datos primitivos y cadenas y 
 * 					opcionalmente tener saltos de líneas 
 * 
 * se puede pasar un flujo de bytes a caracteres con:
 * 		InputStreamReader y OutputStreamWriter
 * 
 * PROPÓSITOS:
 * 		ENTRADA: InputStream, Reader
 * 		SALIDA: OutputStream, Write
 * LECTURA/ESCRITURA:
 * 		RandomAccessFile
 * Transformación de datos:
 * 		BufferedReader, BufferedWriter
 * 
 ***************************************************************/
package archivos;

import java.io.FileWriter;

public class CracionDeArchivo {
	public static void main(String[] args) {
		String texto = "Hola PlatziJava";
		String ruta = "/home/jose/workspace/Platzi/src/archivos/";
		String nombreArchivo = "miArchivoPlatzi.txt";
		try{
			FileWriter archivo = new FileWriter(ruta + nombreArchivo);
			archivo.write(texto);
			System.out.println("Archivo escrito correctamente");
			archivo.close();
			System.out.println("Archivo cerrado correctamente");
		}catch (Exception e){
			System.out.println("No se ha podido crear o escribir el archivo");
		}
	}
}
