package hulu._121_Best_Time_to_Buy_and_Sell_Stock;

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
    int max = 0;
    for (int i = 1, min = prices[0]; i < prices.length; ++i) {
      max = Math.max(max, prices[i] - min);
      min = Math.min(min, prices[i]);
    }
    return max;
  }
}
