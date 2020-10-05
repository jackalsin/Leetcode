package linkedin._879_Profitable_Schemes;

public final class SolutionIII implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int profitableSchemes(int G, int P, int[] group, int[] profit) {
    final int[][] dp = new int[P + 1][G + 1];
    dp[0][0] = 1;
    for (int k = 0; k < group.length; ++k) {
      final int g = group[k], p = profit[k];
      for (int i = P; i >= 0; --i) {
        for (int j = G - g; j >= 0; --j) {
          dp[Math.min(P, i + p)][j + g] = safeAdd(dp[Math.min(P, i + p)][j + g], dp[i][j]);
        }
      }
    }
    int sum = 0;
    for (int i = 0; i <= G; i++) {
      sum = safeAdd(sum, dp[P][i]);
    }
    return sum;
  }

  private static int safeAdd(int a, int... b) {
    int sum = a;
    for (int e : b) {
      sum = (e + sum) % MOD;
    }
    return sum;
  }
}
