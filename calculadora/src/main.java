import java.util.*;
public class main {
	static float total = 0;
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		System.out.println("Introduzca la operacion: ");
		String operacion = t.nextLine();
		ArrayList <Float> numeros = new ArrayList<Float>();
		ArrayList <String> signos = new ArrayList<String>();
		for(int i = 0; i < operacion.length(); i++){
			if(operacion.charAt(i)=='+'){
				int a = Integer.parseInt(operacion.substring(0, i)); //Transformo los numeros a enteros porque add no me deja ingresar float teoricamente
				numeros.add((float)a);
				signos.add("+");
				operacion = operacion.substring(i+1, operacion.length());
				i=0;
			}else{
				if(operacion.charAt(i)=='-'){
					int a = Integer.parseInt(operacion.substring(0, i));
					numeros.add((float)a);
					signos.add("-");
					operacion = operacion.substring(i+1, operacion.length());
					i=0;
				}
				else{
					if(operacion.charAt(i)=='*'){
						int a = Integer.parseInt(operacion.substring(0, i));
						numeros.add((float)a);
						signos.add("*");
						operacion = operacion.substring(i+1, operacion.length());
						i=0;
					}else{
						if(operacion.charAt(i)=='/'){
							int a = Integer.parseInt(operacion.substring(0, i));
							numeros.add((float)a);
							signos.add("/");
							operacion = operacion.substring(i+1, operacion.length());
							i=0;
						}else{
							if(operacion.charAt(i)=='^'){
								int a = Integer.parseInt(operacion.substring(0, i));
								numeros.add((float)a);
								signos.add("^");
								operacion = operacion.substring(i+1, operacion.length());
								i=0;
							}
						}
					}
				}
			}
		}
		int a = Integer.parseInt(operacion.substring(0, operacion.length()));
		numeros.add((float)a);
		/*for(int i = 0; i < numeros.size(); i++){
			System.out.println(numeros.get(i));
		}
		for(int i = 0; i < signos.size(); i++){
			System.out.println(signos.get(i));
		}*/
		for(int i = 0; i < signos.size(); i++){
			if(i==0){
				operar(numeros.get(i), numeros.get(i+1), signos.get(i));
			}else{
				operar(total, numeros.get(i+1), signos.get(i));
			}
		}
		System.out.println("El total es: " + total);
	}
	static void operar(float a, float b, String c){
		if(c.compareTo("+")==0){
			total = a + b;
		}else{
			if(c.compareTo("-")==0){
				total = a - b;
			}else{
				if(c.compareTo("*")==0){
					total = a * b;
				}else{
					if(c.compareTo("/")==0){
						total = a / b;
					}else{
						if(c.compareTo("^")==0){
							total = (int)a ^ (int)b;
						}
					}
				}
			}
		}
	}
}
