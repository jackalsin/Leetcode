package _351_400._375_Guess_Number_Higher_or_Lower_II;

public class Solution {
  /**
   * explanation: https://discuss.leetcode.com/topic/68252/clarification-on-the-problem-description-problem-description-need-to-be-updated
   *
   * @param n
   * @return
   */
  public int getMoneyAmount(int n) {
    if (n == 0) {
      return 0;
    }

    final int[][] dp = new int[n + 1][n + 1];
    for (int jMinusI = 1; jMinusI < n; jMinusI++) {
      for (int i = 0; jMinusI + i <= n; i++) {
        int j = jMinusI + i;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
                                      /* spend k, then you will know which way to go */
          dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
        }
      }
    }
    return dp[1][n];
  }
}
