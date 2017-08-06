package _151_200._188_Best_Time_to_Buy_and_Sell_Stock_IV;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class Solution {
  public int maxProfit(final int k, int[] prices) {
    if (prices.length == 0) return 0;
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

}
