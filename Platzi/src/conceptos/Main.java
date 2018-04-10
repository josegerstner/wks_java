package conceptos;
/***********************************************************
 * 
 *			BUENAS PRÁCTICAS
 * 
 * DEFINICIÓN DE VARIABLES
 *  constantes: VALOR_MAXIMO, VALOR_MINIMO, PI, etc...
 *  variables, objetos y métodos: getValue(), valorMaximo, etc... (lower camel case)
 *  clases: ClasePrincipal, MardoDePanel, etc... (upper camel case)
 * 
 * ENTRADA DE DATOS CON SCANNER
 * Cerrar la entrada una vez utilizada
 * 		Scanner entradaTeclado = new Scanner(System.in);
 * 		String dato = entradaTeclado.nextLine();
 * 		entradaTeclado.close();
 * ........................................................
 * int[] nombreDeArray ó int nombreDeArray[];
 * podemos tener arrays de más dimensiones
 * 
 **********************************************************/
public class Main {
	public static void main(String[] args) {
		int nombreDelArray[][] = new int[3][3];
		byte contador = 0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				nombreDelArray[i][j] = ++contador;
			}
		}
		for(int[] e: nombreDelArray){
			System.out.println(e);
		}
		/*for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.println(nombreDelArray[i][j]);
			}
		}*/
	}
}
