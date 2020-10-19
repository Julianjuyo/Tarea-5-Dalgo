package uniandes.algorithms.coinchange;

public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm {

    /*
     * PRE: The list must be sorted by denomination and the first denomination must
     * be 1
     */
    @Override
    public int[] calculateOptimalChange(int totalValue, int[] denominations) {
        int[] greedyAnswer = new int[denominations.length];
        int sum = 0;
        for (int i = denominations.length - 1; i >= 0 && sum < totalValue; i--) {
            boolean max=false;
        	while (sum < totalValue && !max) {
                int add = denominations[i];
                if (sum + add <= totalValue) {
                    sum += add;
                    greedyAnswer[i]++;
                } else {
                    max=true;
                }
            }
        }
        return greedyAnswer;
    }

}
