package discoduroderoer;
public class DelUnoAlCienWhile {
	public static void main(String[] args) {
		System.out.println("Los números del 1 al 100 son: ");
		imprimir();
	}
	private static void imprimir(){
		int i = 1;
		while(i <= 100){
			System.out.printf(i + "\t");
			if(i%10==0){
				System.out.printf("\n");
			}
			i++;
		}
	}
}
