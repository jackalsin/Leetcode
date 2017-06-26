package _101_150._123_Best_Time_to_Buy_and_Sell_Stock_III;

import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public class Solution {
  public int maxProfit(int[] prices) {
    return dpSolution(prices);
//    return dpSolution();
  }

  private int dpSolution(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    } else {
      final int K = 2;
      int maxProf = 0;
      int[][] dp = new int[K + 1][prices.length];
      for (int kk = 1; kk <= K; kk++) {
        int tmpMax = dp[kk-1][0] - prices[0];
        for (int ii = 1; ii < prices.length; ii++) {
          dp[kk][ii] = Math.max(dp[kk][ii-1], prices[ii] + tmpMax);
          tmpMax = Math.max(tmpMax, dp[kk-1][ii] - prices[ii]);
          maxProf = Math.max(dp[kk][ii], maxProf);
        }
      }
      return maxProf;
    }
  }
}
