package linkedin._730_Count_Different_Palindromic_Subsequences;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionIV implements Solution {
  private static final int BASE = (int) 1e9 + 7;

  public int countPalindromicSubsequences(String s) {
    if (s == null) {
      return 0;
    }
    final int n = s.length();
    final char[] chars = s.toCharArray();
    final int[][][] dp = new int[4][n][n];
    for (int i = n - 1; i >= 0; --i) {
      for (int j = i; j < n; ++j) {
        for (int k = 0; k < 4; k++) {
          final char chr = (char) ('a' + k);
          if (i == j) {
            if (chars[i] == chr) {
              dp[k][i][i] = 1;
            }
          }  /*end of i == j*/ else if (chr != chars[i]) {
            dp[k][i][j] = dp[k][i + 1][j];
          } else if (chr != chars[j]) {
            dp[k][i][j] = dp[k][i][j - 1];
          } else {
            assert chars[j] == chr && chars[i] == chr;
            dp[k][i][j] = 2;
            for (int m = 0; m < 4; ++m) {
              dp[k][i][j] = safeAdd(dp[k][i][j], dp[m][i + 1][j - 1]);
            }
          }
        }
      }
    }

    int res = 0;
    for (int i = 0; i < 4; ++i) {
      res = safeAdd(res, dp[i][0][n - 1]);
    }
    return res;
  }

  private static int safeAdd(final int a, final int... b) {
    int res = a;
    for (int c : b) {
      res = (a + c) % BASE;
    }
    return res;
  }
}
