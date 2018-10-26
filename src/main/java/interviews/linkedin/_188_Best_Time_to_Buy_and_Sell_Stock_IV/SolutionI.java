package interviews.linkedin._188_Best_Time_to_Buy_and_Sell_Stock_IV;

public final class SolutionI implements Solution {
  @Override
  public int maxProfit(final int K, int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    if (K >= prices.length / 2) {
      return fullPower(prices);
    }
    final int[][] maxProfit = new int[K + 1][prices.length];
    for (int k = 1; k <= K; ++k) {
      int tmp = maxProfit[k - 1][0] - prices[0];
      for (int i = 1; i < prices.length; ++i) {
        maxProfit[k][i] = Math.max(maxProfit[k][i - 1], tmp + prices[i]);
        tmp = Math.max(tmp, maxProfit[k - 1][i] - prices[i]);
      }
    }
    return maxProfit[K][prices.length - 1];
  }

  private static int fullPower(final int[] prices) {
    int sum = 0;
    for (int i = 1; i < prices.length; ++i) {
      if (prices[i] > prices[i - 1]) {
        sum += prices[i] - prices[i - 1];
      }
    }
    return sum;
  }

}
