package interviews.hulu._123_Best_Time_to_Buy_and_Sell_Stock_III;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    return maxProfit(prices, 2);
  }

  private int maxProfit(final int[] prices, final int K) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int[][] maxProfit = new int[K + 1][prices.length];
    for (int k = 1; k <= K; k++) {
//      maxProfit[k][0]
      int maxRemainOnT = maxProfit[k - 1][0] - prices[0];
      for (int i = 1; i < prices.length; i++) {
        maxProfit[k][i] = Math.max(maxProfit[k][i - 1], maxRemainOnT + prices[i]);
        maxRemainOnT = Math.max(maxRemainOnT, maxProfit[k - 1][i] - prices[i]);
      }
    }
//    display(maxProfit);
    return maxProfit[K][prices.length - 1];
  }
}
