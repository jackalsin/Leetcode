package _0851_0900._877_Stone_Game;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean stoneGame(int[] piles) {
    final int n = piles.length;
    final int[] preSum = new int[n + 1];
    for (int i = 0; i < n; ++i) {
      preSum[i + 1] = preSum[i] + piles[i];
    }
    final int[][] dp = new int[n][n];
    for (int i = n - 1; i >= 0; --i) {
      dp[i][i] = piles[i];
      for (int j = i + 1; j < n; ++j) {
        dp[i][j] = Math.max(
            piles[i] + (sum(preSum, i + 1, j) - dp[i + 1][j]),
            piles[j] + (sum(preSum, i, j - 1) - dp[i][j - 1])
        );
      }
    }
//    TwoDimensionArray.println(dp);
    return dp[0][n - 1] > preSum[n] - dp[0][n - 1];
  }

  private static int sum(final int[] presum, final int i, final int j) {
    return presum[j + 1] - presum[i];
  }
}
