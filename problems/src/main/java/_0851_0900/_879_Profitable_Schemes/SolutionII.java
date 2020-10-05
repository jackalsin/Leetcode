package _0851_0900._879_Profitable_Schemes;

public final class SolutionII implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int profitableSchemes(int G, int P, int[] group, int[] profit) {
    if (profit == null || profit.length == 0) {
      return 0;
    }
    // dp[p][g] denotes with use exactly <tt>g</tt> person, generate p profit
    final int[][] dp = new int[P + 1][G + 1];
    dp[0][0] = 1;
    for (int k = 0; k < group.length; k++) {
      final int p = profit[k], g = group[k];
      for (int i = P; i >= 0; i--) {
        for (int j = G - g; j >= 0; j--) {
          dp[Math.min(P, i + p)][j + g] = safeAdd(dp[i][j], dp[Math.min(P, i + p)][j + g]);
        }
      }
    }
    int sum = 0;
    for (int e : dp[P]) {
      sum = safeAdd(e, sum);
    }
    return sum;
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }
}
