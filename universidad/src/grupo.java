import java.util.*;
public class grupo {
	char grupo;
	public void alumno(Scanner t){
		System.out.println("Ingrese el alumno: ");
		String al = t.next(); 
		alumno a = new alumno();
		a.setAlumno(al);
		System.out.println(a.getAlumno());
	}
	public void setGrupo(char a){
		grupo = a;
	}
	public char getGrupo(){
		return grupo;
	}
}
