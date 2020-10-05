package pureStorage._0730_Count_Different_Palindromic_Subsequences;

/**
 * @author jacka
 * @version 1.0 on 10/7/2019
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int countPalindromicSubsequences(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    final int n = s.length();
    final int[][][] dp = new int[4][s.length()][s.length()];
    for (int i = n - 1; i >= 0; --i) {
      final char iChar = s.charAt(i);
      for (int j = i; j < n; ++j) {
        final char jChar = s.charAt(j);
        for (int k = 0; k < 4; ++k) {
          final char chr = (char) (k + 'a');
          if (i == j) {
            dp[k][i][j] = (chr == iChar && chr == jChar) ? 1 : 0;
          } else {
            if (iChar == chr && jChar == chr) {
              dp[k][i][j] = safeAdd(dp[0][i + 1][j - 1],
                  dp[1][i + 1][j - 1], dp[2][i + 1][j - 1], dp[3][i + 1][j - 1], 2);
            } else if (iChar == chr) {
              dp[k][i][j] = dp[k][i][j - 1];
            } else if (jChar == chr) {
              dp[k][i][j] = dp[k][i + 1][j];
            } else {
              dp[k][i][j] = dp[k][i + 1][j - 1];
            }
          }
        }
      }
    }
    return safeAdd(dp[0][0][n - 1], dp[1][0][n - 1], dp[2][0][n - 1], dp[3][0][n - 1]);
  }

  private static int safeAdd(int a, final int... b) {
    for (int c : b) {
      a = (a + c) % MOD;
    }
    return a;
  }
}
