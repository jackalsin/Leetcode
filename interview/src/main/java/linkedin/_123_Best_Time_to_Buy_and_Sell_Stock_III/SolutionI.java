package linkedin._123_Best_Time_to_Buy_and_Sell_Stock_III;

public final class SolutionI implements Solution {
  private static final int K = 2;

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int[][] maxProfit = new int[K + 1][prices.length];
    for (int k = 1; k <= K; ++k) {
      int tmp = maxProfit[k - 1][0] - prices[0];

      for (int i = 1; i < prices.length; ++i) {
        maxProfit[k][i] = Math.max(maxProfit[k][i - 1], prices[i] + tmp);
        tmp = Math.max(tmp, maxProfit[k - 1][i] - prices[i]);
      }
    }
    return maxProfit[K][prices.length - 1];
  }
}
