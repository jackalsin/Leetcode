package linkedin._309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public final class SolutionI implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int n = prices.length;
    final int[] maxHolding = new int[prices.length],
        maxSell = new int[prices.length],
        maxToBuy = new int[prices.length];
    maxHolding[0] = -prices[0];
    for (int i = 1; i < n; ++i) {
      maxHolding[i] = Math.max(maxHolding[i - 1], maxToBuy[i - 1] - prices[i]);
      maxSell[i] = maxHolding[i - 1] + prices[i];
      maxToBuy[i] = Math.max(maxSell[i - 1], maxToBuy[i - 1]);
    }

    return Math.max(Math.max(maxHolding[n - 1], maxSell[n - 1]), maxToBuy[n - 1]);
  }
}
