package interviews.oracle._121_Best_Time_to_Buy_and_Sell_Stock;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int max = 0, low = prices[0];
    for (int i = 1; i < prices.length; i++) {
      max = Math.max(max, prices[i] - low);
      low = Math.min(low, prices[i]);
    }
    return max;
  }
}
