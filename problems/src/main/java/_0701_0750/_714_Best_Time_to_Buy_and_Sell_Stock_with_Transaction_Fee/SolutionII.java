package _0701_0750._714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

/**
 * @author jacka
 * @version 1.0 on 5/18/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int maxProfit(int[] prices, int fee) {
    if (prices == null || prices.length == 0) return 0;
    final int n = prices.length;
    final int[] buys = new int[n], sells = new int[n];
    buys[0] = -prices[0];
    for (int i = 1; i < n; ++i) {
      buys[i] = Math.max(buys[i - 1], sells[i - 1] - prices[i]);
      sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i] - fee);
    }
    return sells[n - 1];
  }
}
