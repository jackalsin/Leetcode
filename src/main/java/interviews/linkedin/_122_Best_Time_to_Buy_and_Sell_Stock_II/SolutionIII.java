package interviews.linkedin._122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }
    int profit = 0;
    for (int i = 1; i < prices.length; ++i) {
      final int diff = prices[i] - prices[i - 1];
      if (diff > 0) {
        profit += diff;
      }
    }
    return profit;
  }
}
