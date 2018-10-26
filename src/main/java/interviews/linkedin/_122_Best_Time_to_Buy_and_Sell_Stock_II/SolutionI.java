package interviews.linkedin._122_Best_Time_to_Buy_and_Sell_Stock_II;

public final class SolutionI implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; ++i) {
      if (prices[i] > prices[i - 1]) {
        max += prices[i] - prices[i - 1];
      }
    }
    return max;
  }
}
