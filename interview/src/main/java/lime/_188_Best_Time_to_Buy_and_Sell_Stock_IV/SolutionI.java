package lime._188_Best_Time_to_Buy_and_Sell_Stock_IV;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public final class SolutionI implements Solution {

  public int maxProfit(final int K, final int[] prices) {
    if (K <= 0 || prices == null || prices.length == 0) {
      return 0;
    }
    final int n = prices.length;
    if (K > n / 2) {
      return getMax(prices);
    }
    final int[][] dp = new int[K + 1][n + 1];
    for (int k = 1; k <= K; ++k) {
      int temp = dp[k - 1][0] - prices[0];
      dp[k][0] = dp[k - 1][0];
      for (int i = 1; i < n; ++i) {
        dp[k][i + 1] = dp[k][i];
        dp[k][i + 1] = Math.max(dp[k][i + 1], temp + prices[i]);
        temp = Math.max(temp, dp[k - 1][i] - prices[i]);
      }
    }
    return dp[K][n];
  }

  private int getMax(final int[] prices) {
    int sum = 0;
    for (int i = 1; i < prices.length; ++i) {
      sum += Math.max(0, prices[i] - prices[i - 1]);
    }
    return sum;
  }
}
