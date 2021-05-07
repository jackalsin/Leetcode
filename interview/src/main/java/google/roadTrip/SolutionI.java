package google.roadTrip;

/**
 * @author jacka
 * @version 1.0 on 5/6/2021
 */
public final class SolutionI implements Solution {
  @Override
  public Cost getMinCost(final Cost[][] costs, final int start, final int end) {
    if (costs == null || costs.length == 0) return Cost.of(0, 0);
    final int n = costs.length;
    final Cost[][] dp = new Cost[n][n];
//    Arrays.fill(dp[0], Cost.MAX_VALUE);
    dp[0][start] = Cost.of(0, 0);
    for (int i = 0; i < n - 1; ++i) {
      System.arraycopy(dp[i], 0, dp[i + 1], 0, n);
      for (int j = 0; j < n; ++j) {
        if (dp[i][j] == null) continue;
        for (int k = 0; k < costs[j].length; ++k) {
          final Cost toAdd = costs[j][k];
          if (toAdd == null) continue;
          dp[i + 1][k] = min(dp[i + 1][k], add(dp[i][j], toAdd));
        }
      }
    }
    return dp[n - 1][end];
  }

  private static Cost add(final Cost a, final Cost b) {
    if (a == null) return b;
    if (b == null) return a;
    return Cost.of(a.board + b.board, a.distance + b.distance);
  }

  private static Cost min(final Cost a, final Cost b) {
    if (a == null) return b;
    if (b == null) return a;
    if (a.board < b.board) return a;
    if (b.board < a.board) return b;
    if (b.distance < a.distance) return b;
    return a;
  }
}
