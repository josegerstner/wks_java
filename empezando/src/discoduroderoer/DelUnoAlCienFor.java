package discoduroderoer;

public class DelUnoAlCienFor {
	public static void main(String[] args) {
		System.out.println("Los números del 1 al 100 son: ");
		imprimir();
	}
	private static void imprimir(){
		for(int i=1; i<=100; i++){
			System.out.printf(i + "\t");
			if(i%10==0){
				System.out.printf("\n");
			}
		}
	}
}
