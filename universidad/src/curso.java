import java.util.*;
public class curso {
	int curso;
	public void grupo(Scanner t){
		System.out.println("Ingrese el grupo: ");
		String gru = t.next(); 
		char a = gru.charAt(0);
		grupo g = new grupo();
		g.setGrupo(a);
		System.out.println(g.getGrupo());
		g.alumno(t);
	}
	public void setCurso(int a){
		curso = a;
	}
	public int getCurso(){
		return curso;
	}
}
