package dynamicProgramming._188_Best_Time_to_Buy_and_Sell_Stock_IV;

public class Solution {
  public int maxProfit(final int K, int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    if (K > prices.length / 2) {
      return unlimitedTransaction(prices);
    }
    int maxProfit = 0;
    final int[][] dp = new int[K + 1][prices.length];
    for (int k = 1; k <= K; k++) {
      int tmpMax = dp[k - 1][0] - prices[0];
      for (int j = 1; j < prices.length; j++) {
        dp[k][j] = Math.max(dp[k][j - 1], tmpMax + prices[j]);
        tmpMax = Math.max(dp[k - 1][j] - prices[j], tmpMax);
        maxProfit = Math.max(maxProfit, dp[k][j]);
      }
    }
    return maxProfit;
  }

  private static int unlimitedTransaction(final int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      maxProfit += Math.max(0, prices[i] - prices[i - 1]);
    }
    return maxProfit;
  }
}
