package paradigma;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class User {
	public User(String nombre){
		this.nombre = nombre; 
		categoria = "Novato";
		posts = new ArrayList<Post>();
	}
	
	int valorar(){
		int suma=0;
		for(Post p: posts){
			suma += p.getPuntos();
		}
		return suma;
	}
	void dejarPuntos(int puntos, Post post){
		post.sumarPuntos(puntos);
	}
	void promoverCategoria(){
		if(categoria.equals("Novato") && this.valorar()>=100){
			JOptionPane.showMessageDialog(null, "Fuiste promovido a usuario 'Intermedio'");
			categoria="Intermedio";
		}else if(categoria.equals("Intermedio") && this.valorar()>=1000){
			for(Post p: posts){
				if(p.getPuntos()>500){
					JOptionPane.showMessageDialog(null, "Fuiste promovido a usuario 'Experto'");
					categoria = "Experto";
					JOptionPane.showMessageDialog(null, "Ya podés hacer post premium");
					premium = true;
					//si ya tiene un post con más de 500 points tiene que salir
					break;
				}
			}
		}
	}
	ArrayList<String> verPosts(){
		ArrayList<String> lista = new ArrayList<String>();
		for(Post p: posts){
			lista.add(p.getNombre());
		}
		return lista;
	}
	private boolean premium = false;
	String categoria;
	ArrayList<Post> posts;
	String nombre;
}
