package vectoresOarrays;

public class vectores {

	public static void main(String[] args) {
//Arrays numéricos y de caracteres
		int arr[] = new int[5];
		arr[3] = 42;
		System.out.println(arr[3]);
		String[] myNames = {"A", "B", "C", "D"};
		System.out.println(myNames[2]);
//length = largo del array
		int[] intArr = new int[5];
		System.out.println(intArr.length);
		
		int[] myArr = {6, 42, 3, 7};
		int sum = 0;
		for(int x=0; x<myArr.length; x++){
			sum += myArr[x];
		}
		System.out.println(sum);
//Enhanced for = for mejorado
		int[] primes = {2, 3, 5, 7};
		for(int t: primes){
			System.out.println(t);
		}
//Multidimensional Arrays
		//arrayMultidimensional[numeroDeArray][posiciónEnElArray]
		int[][] sample = {{1, 2, 3}, {4, 5, 6}};
		int x = sample[1][0];
		System.out.println(x);
		//lo puedo inicializar como se me cante
		int[][] myArrs = {{1, 2, 3}, {4}, {5, 6, 7}};
		myArrs[0][2] = 42;
		x = myArrs[1][0];
		System.out.println(x);
	}
}