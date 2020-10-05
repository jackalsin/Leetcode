package linkedin._879_Profitable_Schemes;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class SolutionIV implements Solution {
  private static final int BASE = (int) (1E9 + 7);

  public int profitableSchemes(int G, int P, int[] groups, int[] profits) {
    if (G <= 0 || groups == null || profits == null) {
      return 0;
    }
    if (P <= 0) {
      return -1;
    }
    final int[][] dp = new int[P + 1][G + 1];
    dp[0][0] = 1;

    for (int k = 0; k < profits.length; k++) {
      final int g = groups[k], p = profits[k];
      for (int i = P; i >= 0; --i) {
        for (int j = G - g; j >= 0; --j) {
          final int row = Math.min(P, p + i);
          dp[row][j + g] = safeAdd(dp[row][j + g], dp[i][j]);
        }
      }
    }
    int res = 0;
    for (int c : dp[P]) {
      res = safeAdd(c, res);
    }
    return res;
  }

  private static int safeAdd(final int a, final int... b) {
    int res = a;
    for (int c : b) {
      res = (res + c) % BASE;
    }
    return res;
  }
}
