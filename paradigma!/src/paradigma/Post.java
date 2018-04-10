package paradigma;

import java.util.ArrayList;

public class Post {
	public Post(String nombre, String contenido, boolean premium){
		puntos = 0;
		this.premium = premium;
		comentarios = new ArrayList<String>();
	}
	String getNombre(){
		return nombre;
	}
	void sumarPuntos(int puntos){
		this.puntos += puntos;
	}
	void agregarComentario(String comentario){
		comentarios.add(comentario);
	}
	int getPuntos(){
		if(this.isPremium()){
			return sumarPuntos()*2;
		}else{
			return sumarPuntos();
		}
	}
	ArrayList<String> getComentarios(){
		return comentarios;
	}
	private int sumarPuntos(){
		return puntos + comentarios.size();
	}
	private boolean isPremium(){
		return premium;
	}
	private int puntos;
	ArrayList<String> comentarios;
	private boolean premium;
	public String nombre;
	public String contenido;
}
