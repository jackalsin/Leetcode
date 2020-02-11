package interviews.hulu._122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int sum = 0;
    for (int i = 1; i < prices.length; ++i) {
      sum += Math.max(0, prices[i] - prices[i - 1]);
    }
    return sum;
  }
}
