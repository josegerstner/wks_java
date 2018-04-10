package archivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Formatter;
import javax.swing.JOptionPane;
@SuppressWarnings("unused")
public class ManejoDeArchivos {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		//instanciamos el objeto archivo
		File doc = new File("C:\\Users\\GRN\\Documents\\JAVA - Espacio de trabajo\\archivos\\src\\archivo.txt");
		//preguntamos si el archivo existe
		if(doc.exists()){
			JOptionPane.showMessageDialog(null, "Encontrado");
			//escribir el documento
			//debe tener un try catch
			try{
				//instanciamos un objeto de la clase FileWriter
				//en el constructor le pasamos el objeto o la dirección a leer 
				//y un true para que agregue datos, no sobreescriba o un false para sobreescribir
				FileWriter escritor = new FileWriter(doc, true);
				//hay varias maneras de ingresar datos
				escritor.append(JOptionPane.showInputDialog("Ingrese una línea de texto") + "\n");
				/*
				 * esta manera sólo agrega texto, no sobreescribe
				//escritor.write("Texto a ingresar");*/
				escritor.close();
				/* este manera sólo sobre escribe
				PrintWriter pr = new PrintWriter(doc);
				//println agrega un salto de línea al texto
				pr.println("Texto a ingresar");
				pr.append("Texto a ingresar");
				pr.printf("Texto a ingresar %s", variableOTexto);
				pr.close();
				
				
				BufferedWriter bw = new BufferedWriter(escritor);
				bw.write("Texto a agregar");
				bw.append("Texto a agregar");
				bw.close();
				*/
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "El error es "+ e);
			}

			//leer el documento
			//debe tener preparada la excepción
			try{
				FileReader lector = new FileReader("C:\\Users\\GRN\\Documents\\JAVA - Espacio de trabajo\\archivos\\src\\archivo.txt");
				int num;
				String cadena;
				BufferedReader br = new BufferedReader(lector);//guarda en un buffer hasta el salto de línea
				//imprimimos lo que hay hasta el salto de línea
				while((cadena=br.readLine()) != null){
					JOptionPane.showMessageDialog(null, cadena);
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "El error es "+ e);
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "No encontrado");
			//si el archivo no existe, lo creamos
			//debe estar preparado por si no se puede crear el archivo
			try{
				Formatter nuevoDoc = new Formatter("C:\\Users\\GRN\\Documents\\JAVA - Espacio de trabajo\\archivos\\src\\archivo.txt");
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "El error es: " + e);
			}
		}
		
	}
}
