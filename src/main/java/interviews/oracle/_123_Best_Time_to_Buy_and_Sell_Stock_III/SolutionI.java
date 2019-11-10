package interviews.oracle._123_Best_Time_to_Buy_and_Sell_Stock_III;

import static utils.TwoDimensionArray.display;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    return maxProfit(prices, 2);
  }

  private static int maxProfit(final int[] prices, final int K) {
    final int N = prices.length;
    if (K >= N / 2) {
      return fullTransaction(prices);
    }
    final int[][] dp = new int[K + 1][N];
    for (int k = 1; k <= K; ++k) {
      int max = -prices[0] + dp[k - 1][0];
      for (int i = 1; i < N; ++i) {
        dp[k][i] = Math.max(dp[k][i - 1], max + prices[i]);
        max = Math.max(max, -prices[i] + dp[k - 1][i]);
      }
    }
//    display(dp);
    return dp[K][N - 1];
  }

  private static int fullTransaction(final int[] prices) {
    int sum = 0;
    for (int i = 1; i < prices.length; ++i) {
      sum += Math.max(0, prices[i] - prices[i - 1]);
    }
    return sum;
  }
}
