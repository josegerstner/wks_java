import java.util.*;
public class main {
	static Scanner t = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Ingrese el curso: ");
		int curso = t.nextInt();
		curso c = new curso();
		c.setCurso(curso);
		System.out.println(c.getCurso());
		c.grupo(t);
		
	}

}
