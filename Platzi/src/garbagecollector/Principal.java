package garbagecollector;

public class Principal {
	public static void main(String[] args) {
		Persona persona1 = new Persona();
		@SuppressWarnings("unused")
		Persona persona2 = new Persona();
		
		persona1.setNombre("Bart Simpson");
		persona2 = persona1;
		//la información "Bart Simpson" se pierde ya que no hay nadie apuntado a ella
		persona1 = null;
		persona2 = null;
		//el método System.gc() llama al recolector de basura
		System.gc();
	}
}
