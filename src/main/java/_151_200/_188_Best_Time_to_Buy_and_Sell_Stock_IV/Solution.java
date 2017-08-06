package _151_200._188_Best_Time_to_Buy_and_Sell_Stock_IV;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class Solution {

  public int maxProfit(final int k, int[] prices) {
    if (prices.length == 0) return 0;
    if (k > prices.length / 2) { // at most we can price.length /2 transactions
      return quickSolve(prices);
    }
    final int[] maxProfits = new int[prices.length];
    for(int i = 1; i <= k; ++i) {
      int tempMax = maxProfits[0] - prices[0];
      for(int j = 1; j < prices.length; ++j) {
        int preTempMax = maxProfits[j] - prices[j];
        int dontDoTransaction = maxProfits[j - 1];
        int doTransaction = prices[j] + tempMax;
        maxProfits[j] = Math.max(dontDoTransaction, doTransaction);
        tempMax = Math.max(tempMax, preTempMax);
      }
    }
    return maxProfits[prices.length - 1];
  }

  private static int quickSolve(int[] prices) {
    int result = 0;
    for (int i = 1; i < prices.length; i++) {
      int profit = prices[i] - prices[i - 1];
      result += profit <= 0 ? 0 : profit;
    }
    return result;
  }

}
