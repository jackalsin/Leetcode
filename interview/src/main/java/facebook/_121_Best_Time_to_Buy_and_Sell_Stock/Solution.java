package facebook._121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int maxProfit = 0, minBuy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, -minBuy + prices[i]);
      minBuy = Math.min(minBuy, prices[i]);
    }
    return maxProfit;
  }
}
