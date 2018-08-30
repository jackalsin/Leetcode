package dynamicProgramming._121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int maxProfit = 0, lowest = prices[0];
    for (int i = 1; i < prices.length; ++i) {
      maxProfit = Math.max(maxProfit, prices[i] - lowest);
      lowest = Math.min(lowest, prices[i]);
    }
    return maxProfit;
  }
}
