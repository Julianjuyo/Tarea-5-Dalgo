package uniandes.algorithms.coinchange;

public class Parte2Ejercicio3 {

	/**
	 * Precondición: 	todos los números son naturales o 0.
	 * 					la lista de números no es vacía
	 * @param args[0]= lista de números
	 * @param args[1]= valor total T
	 * 
	 */
	public static void main(String[] args) {

		int N = 3;

		System.out.println("Resultado: "+CantidadNDígitosBase4(N));
	}

	public static int CantidadNDígitosBase4(int N){
		int m[][]= new int[N+1][4+1];
		int b=0;

		for (int n = 0; n <=N; n++) {
			b=0;
			for(int j=0 ; j<4 ; j++)
			{		
				int sumaTemporal=0;

				if(n==0){
					sumaTemporal=0;
					m[n][j]= sumaTemporal;
				}
				else if(n==1){
					sumaTemporal=1;
					m[n][j]= sumaTemporal;
				}
				else if(n>1 && j==0){ 
					sumaTemporal= m[n-1][1]+m[n-1][2]+m[n-1][3];
					m[n][j]= sumaTemporal;
				}
				else if(n>1 && j>0){
					sumaTemporal= m[n-1][0]+m[n-1][1]+ m[n-1][2]+ m[n-1][3];
					m[n][j]=sumaTemporal;
				}
				b += sumaTemporal;	
			}
		}
		return b;
	}
}
