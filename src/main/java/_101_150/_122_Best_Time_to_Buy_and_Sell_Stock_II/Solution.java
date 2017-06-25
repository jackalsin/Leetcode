package _101_150._122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * @author jacka
 * @version 1.0 on 6/24/2017.
 */
public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int prev = prices[0];
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      int bias = prices[i] - prev;
      prev = prices[i];
      if (bias > 0) profit += prev;
    }
    return profit;
  }
}
