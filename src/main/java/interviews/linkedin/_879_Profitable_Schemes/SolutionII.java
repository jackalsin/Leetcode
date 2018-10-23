package interviews.linkedin._879_Profitable_Schemes;

public final class SolutionII implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int profitableSchemes(int G, int P, int[] group, int[] profit) {
    final int[][] dp = new int[G + 1][P + 1];
    dp[0][0] = 1;
    for (int k = 0; k < group.length; ++k) {
      final int g = group[k], p = profit[k];
      for (int i = G - g; i >= 0; --i) {
        for (int j = P; j >= 0; --j) {
          dp[i + g][Math.min(j + p, P)] = safeAdd(dp[i + g][Math.min(j + p, P)], dp[i][j]);
        }
      }

    }
    int sum = 0;
    for (int i = 0; i <= G; i++) {
      sum = safeAdd(sum, dp[i][P]);
    }

    return sum;
  }

  private static int safeAdd(final int a, final int... arr) {
    int sum = a;
    for (int n : arr) {
      sum = (sum + n) % MOD;
    }
    return sum;
  }

}
