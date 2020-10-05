package _0851_0900._879_Profitable_Schemes;

public final class SolutionI implements Solution {

  private static final int MOD = (int) (1E9 + 7);

  public int profitableSchemes(int G, int P, int[] group, int[] profit) {

    final int[][] dp = new int[P + 1][G + 1];
    dp[0][0] = 1;
    for (int k = 0; k < group.length; ++k) {
      final int g = group[k], p = profit[k];

      for (int i = P; i >= 0; --i) {
        for (int j = G - g; j >= 0; --j) {
          dp[Math.min(i + p, P)][j + g] = safeAdd(dp[i][j], dp[Math.min(i + p, P)][j + g]);
        }
      }
    }

    int res = 0;
    for (int x : dp[P]) {
      res = safeAdd(res, x);
    }
    return res;
  }


  private static int safeAdd(final int i, final int j) {
    return (i + j) % MOD;
  }
}
