package linkedin._123_Best_Time_to_Buy_and_Sell_Stock_III;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    return maxProfit(2, prices);
  }

  private static int maxProfit(final int K, final int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int[][] maxProfit = new int[K + 1][prices.length];
    for (int k = 1; k <= K; ++k) {
      int tmpMax = -prices[0] + maxProfit[k - 1][0];
      for (int i = 1; i < prices.length; ++i) {
        maxProfit[k][i] = Math.max(maxProfit[k][i - 1], prices[i] + tmpMax);
        tmpMax = Math.max(tmpMax, -prices[i] + maxProfit[k - 1][i]);
      }
    }
    return maxProfit[K][prices.length - 1];
  }
}
