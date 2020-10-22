package uniandes.algorithms.coinchange;

public class ExisteConjuntoSuma {

	/**
	 * Precondición: 	todos los números son naturales o 0.
	 * 					la lista de números no es vacía
	 * @param args[0]= lista de números
	 * @param args[1]= valor total T
	 * 
	 */
	public static void main(String[] args) {

		String[] nums = args[0].split(",");
		int[] nums2 = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			nums2[i]=(Integer.parseInt(nums[i]));
		}
		boolean answer = existeConjuntoSuma(nums2,Integer.parseInt(args[1]));
		System.out.println("Resultado: "+answer);
	}

	public static boolean existeConjuntoSuma(int[] a, int valorTotal) 
	{
		boolean[][] t = new boolean[a.length][valorTotal+1];

		for(int i=0,j=0;i<a.length;)
		{
			if(j<=0 ||( i==0 && a[i]!=j))
			{
				t[i][j]=false;
			}
			else if(a[i]==j || t[i-1][j])
			{
				t[i][j]=true;
			}
			else if(a[i]<j)
			{
				t[i][j]=t[i-1][j-a[i]];
			}
			else
			{
				t[i][j]=t[i-1][j];
			}
			if(j<valorTotal+1)
			{
				j++;
			}
			if(j==valorTotal+1)
			{
				i++;
				j=0;
			}
		}
		return t[a.length-1][valorTotal];
	}
}
