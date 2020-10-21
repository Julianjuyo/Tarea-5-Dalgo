package uniandes.algorithms.coinchange;

public class DPCoinChangeAlgorithm implements CoinChangeAlgorithm {

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int m[][]=new int[denominations.length][totalValue+1];


		for(int i=0,j=0;i<denominations.length;)
		{
			if(i==0)
			{
				m[i][j]=j;
			}
			else if(j==0)
			{
				m[i][j]=0;
			}
			else if(denominations[i]<=j)
			{
				m[i][j]=min(m[i-1][j], m[i][j-denominations[i]]+1);
			}
			else if(i>0 && denominations[i]>j)
			{
				m[i][j]=m[i-1][j];
			}
			if(j<totalValue+1)
			{
				j++;
			}
			if(j==totalValue+1)
			{
				i++;
				j=0;
			}
		}

		int[] dpAnswer=new int[denominations.length];
		for(int i=denominations.length-1,j=totalValue;j>0;)
		{
			if(m[i][j]==m[i-1][j]) 	// significa que no use la moneda de denominacion i esta vez
			{						// reduzco la denominacion
				i--;
			}
			else 					// si use la moneda de denominacion i
			{						// sigo en la denominacion i
				dpAnswer[i]++;
				j-=denominations[i];
			}
		}
		return dpAnswer;
	}
	private int min(int a,int b) {
		return (a<=b)?a:b;
	}
}
