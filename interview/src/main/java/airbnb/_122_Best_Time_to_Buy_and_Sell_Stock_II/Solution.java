package airbnb._122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
public class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      maxProfit += Math.max(0, prices[i] - prices[i - 1]);
    }
    return maxProfit;
  }
}
