package linkedin._256_Paint_House;

/**
 * @author jacka
 * @version 1.0 on 9/1/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    final int n = costs.length, colors = costs[0].length;
    final int[][] dp = new int[n][colors];
    System.arraycopy(costs[0], 0, dp[0], 0, 3);
    for (int i = 1; i < n; ++i) {
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
    }
    return min(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]);
  }

  private static int min(final int a, final int b, final int c) {
    return Math.min(Math.min(a, b), c);
  }
}
