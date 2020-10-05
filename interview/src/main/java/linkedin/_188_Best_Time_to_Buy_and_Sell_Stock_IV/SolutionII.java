package linkedin._188_Best_Time_to_Buy_and_Sell_Stock_IV;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int maxProfit(final int K, final int[] prices) {
    if (K <= 0 || prices == null || prices.length == 0) {
      return 0;
    }
    if (K / 2 >= prices.length) {
      return maxProfit(prices);
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

  private static int maxProfit(final int[] prices) {
    int res = 0;
    for (int i = 1; i < prices.length; ++i) {
      final int diff = prices[i] - prices[i - 1];
      if (diff > 0) {
        res += diff;
      }
    }
    return res;
  }
}
