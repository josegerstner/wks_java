package colecciones;

public class Libro {
	public Libro(String titulo, String autor, int ISBN){
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
	}
	
	public String getDatos(){
		return "El libro " + titulo + " del autor " + autor + " tiene un ISBN de " + ISBN;
	}
	//reescribimos el método equals
	/*public boolean equals(Object obj){
		if(obj instanceof Libro){
			Libro otro = (Libro)obj;
			return this.getISBN() == otro.getISBN();
		}else{
			return false;
		}
	}*/
	
	
	public int getISBN(){
		return ISBN;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (ISBN != other.ISBN)
			return false;
		return true;
	}
	private String titulo, autor;
	private int ISBN;
}
