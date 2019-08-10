package interviews.linkedin._265_Paint_House_II;

/**
 * @author jacka
 * @version 1.0 on 8/7/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    final int n = costs.length, k = costs[0].length;
    final int[][] dp = new int[n][k];

    System.arraycopy(costs[0], 0, dp[0], 0, k);

    for (int i = 1; i < n; i++) {
      final int[] minExceptSelf = getMinExceptSelf(dp[i - 1]);
      for (int j = 0; j < k; j++) {
        dp[i][j] = costs[i][j] + minExceptSelf[j];
      }
    }
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < k; j++) {
      min = Math.min(min, dp[n - 1][j]);
    }
    return min;
  }

  private static int[] getMinExceptSelf(final int[] costs) {
    assert costs != null;
    final int[] res = new int[costs.length];
    int left = Integer.MAX_VALUE;
    for (int i = 0; i < costs.length; i++) {
      res[i] = left;
      left = Math.min(left, costs[i]);
    }
    int right = Integer.MAX_VALUE;
    for (int i = costs.length - 1; i >= 0; i--) {
      res[i] = Math.min(res[i], right);
      right = Math.min(right, costs[i]);
    }
    return res;
  }
}
