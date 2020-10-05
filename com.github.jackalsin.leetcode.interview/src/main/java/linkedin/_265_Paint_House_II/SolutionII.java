package linkedin._265_Paint_House_II;

/**
 * @author jacka
 * @version 1.0 on 9/1/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    final int n = costs.length, colors = costs[0].length;
    final int[][] dp = new int[n][colors];
    System.arraycopy(costs[0], 0, dp[0], 0, colors);
    for (int i = 1; i < n; i++) {
      final int[] minExceptSelf = minExceptSelf(dp[i - 1]);
      for (int color = 0; color < colors; ++color) {
        dp[i][color] = minExceptSelf[color] + costs[i][color];
      }
    }
    return min(dp[n - 1]);
  }

  private static int[] minExceptSelf(final int[] costs) {
    assert costs != null;
    final int[] res = new int[costs.length];
    int left = Integer.MAX_VALUE;
    for (int i = 0; i < costs.length; ++i) {
      res[i] = left;
      left = Math.min(left, costs[i]);
    }
    int right = Integer.MAX_VALUE;
    for (int i = costs.length - 1; i >= 0; --i) {
      res[i] = Math.min(right, res[i]);
      right = Math.min(right, costs[i]);
    }
    return res;
  }

  private static int min(final int[] vals) {
    assert vals.length > 0;
    int c = vals[0];
    for (int i = 1; i < vals.length; i++) {
      c = Math.min(c, vals[i]);
    }
    return c;
  }
}
