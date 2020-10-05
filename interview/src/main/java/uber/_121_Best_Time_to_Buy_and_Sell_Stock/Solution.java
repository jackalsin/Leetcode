package uber._121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
  public int maxProfit(int[] prices) {
    int lowestSoFar = Integer.MAX_VALUE, maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      lowestSoFar = Math.min(lowestSoFar, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - lowestSoFar);
    }
    return maxProfit;
  }
}
