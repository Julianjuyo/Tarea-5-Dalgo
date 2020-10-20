package uniandes.algorithms.coinchange;

public class RecurrentCoinChangeAlgorithm implements CoinChangeAlgorithm {

	/*
	 * PRE: The list must be sorted by denomination and the first denomination must
	 * be 1
	 */
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int[] recurrentAnswer = new int[denominations.length];

		recurrentAnswer[denominations.length-1]=c(totalValue,denominations.length-1,denominations);

		return recurrentAnswer;
	}

	private int c(int j,int i,int[] d) {
		if(j==0)
			return 0;
		else if(i<0)
		{
			return Integer.MAX_VALUE;
		}
		else if(d[i]<=j)
		{
			int min1=c(j,i-1,d);
			int min2=c(j-d[i],i,d)+1;
			return Math.min(min1, min2);
		}
		return c(j,i-1,d);
	}

}
