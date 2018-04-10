package colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class PruebaTreeSet {
	public static void main(String[] args) {
		TreeSet<String> ordenaPersonas = new TreeSet<String>();
		
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		ordenaPersonas.add("Diana");
		
		//podemos ver que se ordenan automáticamente
		for (String s : ordenaPersonas) {
			System.out.println(s);
		}
		//-------------------------------------------------------------
		Articulo primero = new Articulo(1, "primer artículo");
		Articulo segundo = new Articulo(2, "segundo artículo");
		Articulo tercero = new Articulo(3, "tercer artículo");
		TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
		ordenaArticulos.add(primero);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(segundo);
		
		//también los ordena automáticamente por sobreescribir compareTo
		for (Articulo articulo : ordenaArticulos) {
			System.out.println(articulo.getDesription());
		}
		
		//----------------------------------------------------------------
		//ComparadorArticulos comparadorDeArticulos = new ComparadorArticulos();
		//le paso como parámetro al TreeSet el comparator que voy a usar
		//TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorDeArticulos);
		//también podría usar una clase anónima
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(new Comparator<Articulo>(){
			public int compare(Articulo o1, Articulo o2) {
				String desc1 = o1.getDesription();
				String desc2 = o2.getDesription();
				//devuelve la comparación de los objetos
				return desc1.compareTo(desc2);
			}
		});
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(tercero);
		for (Articulo articulo : ordenaArticulos2) {
			System.out.println(articulo.getDesription());
		}
	}
}
class Articulo implements Comparable<Articulo>{
	public Articulo(int number, String descrption){
		this.number = number;
		this.description = descrption;
	}
	//sobreescribimos el método compareTo de la interfaz Comparable
	//para ordenar según el número de artículo
	public int compareTo(Articulo o) {
		return number - o.number;
	}
	
	public String getDesription(){
		return description;
	}
	private int number;
	private String description;
}

class ComparadorArticulos implements Comparator<Articulo>{
	public ComparadorArticulos(){
		
	}
	
	//sobreescribimos el método compare de la interfaz comparator
		//para ordenar según la descripción
		public int compare(Articulo o1, Articulo o2) {
			String desc1 = o1.getDesription();
			String desc2 = o2.getDesription();
			//devuelve la comparación de los objetos
			return desc1.compareTo(desc2);
		}
}