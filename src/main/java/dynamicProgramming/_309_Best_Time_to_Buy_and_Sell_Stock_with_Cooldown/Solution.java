package dynamicProgramming._309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class Solution {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    // dp[i][0] maxProfit I am holding shares
    // dp[i][1] maxProfit I just sell shares
    // dp[i][2] maxProfit I have been ready to buy shares
    final int[][] dp = new int[prices.length][3];
    dp[0][0] = -prices[0];
    for (int i = 1; i < prices.length; ++i) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
      dp[i][1] = dp[i - 1][0] + prices[i];
      dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
    }
    return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
  }

}
