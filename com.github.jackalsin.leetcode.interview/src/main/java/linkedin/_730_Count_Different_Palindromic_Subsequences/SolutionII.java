package linkedin._730_Count_Different_Palindromic_Subsequences;

public final class SolutionII implements Solution {
  private static final int BASE = (int) (1E9 + 7);

  public int countPalindromicSubsequences(String s) {
    final int n = s.length();
    final int[][][] dp = new int[4][s.length()][s.length()];
    for (int i = n - 1; i >= 0; --i) {
      for (int j = i; j < n; j++) {
        for (int k = 0; k < 4; k++) {
          final char chr = (char) ('a' + k);
          if (i == j) {
            if (s.charAt(i) == 'a' + k) {
              dp[k][i][j] = 1;
            }
          } else {
            if (s.charAt(i) == chr && s.charAt(j) == chr) {
              dp[k][i][j] = sum(2, dp[0][i + 1][j - 1], dp[1][i + 1][j - 1], dp[2][i + 1][j - 1], dp[3][i + 1][j - 1]);
            } else if (s.charAt(i) == chr) {
              dp[k][i][j] = dp[k][i][j - 1];
            } else if (s.charAt(j) == chr) {
              dp[k][i][j] = dp[k][i + 1][j];
            } else {
              dp[k][i][j] = dp[k][i + 1][j - 1];
            }
          }
        }
      }
    }

    return sum(dp[0][0][n - 1], dp[1][0][n - 1], dp[2][0][n - 1], dp[3][0][n - 1]);
  }


  private static int sum(final int a0, int... a) {
    int sum = a0;
    for (int elem : a) {
      sum = (sum + elem) % BASE;
    }
    return sum;
  }
}
