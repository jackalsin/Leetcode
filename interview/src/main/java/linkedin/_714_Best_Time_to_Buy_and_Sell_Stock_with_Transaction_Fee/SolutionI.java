package linkedin._714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public final class SolutionI implements Solution {

  @Override
  public int maxProfit(int[] prices, int fee) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int buy[] = new int[prices.length], sell[] = new int[prices.length];
    buy[0] = -prices[0];
    for (int i = 1; i < prices.length; ++i) {
      buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
      sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
    }
    return sell[prices.length - 1];
  }
}
