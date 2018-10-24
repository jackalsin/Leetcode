package interviews.linkedin._730_Count_Different_Palindromic_Subsequences;

public class SolutionIII implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int countPalindromicSubsequences(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    final int n = s.length();
    final int[][][] dp = new int[4][n][n];
    for (int i = n - 1; i >= 0; --i) {
      for (int j = i; j < n; ++j) {
        for (int k = 0; k < 4; ++k) {
          final char chr = (char) ('a' + k);
          if (i == j) {
            dp[k][i][i] = s.charAt(i) == chr ? 1 : 0;
          } else {
            if (s.charAt(i) == chr && chr == s.charAt(j)) {
              dp[k][i][j] = safeAdd(2, dp[0][i + 1][j - 1], dp[1][i + 1][j - 1],
                  dp[2][i + 1][j - 1], dp[3][i + 1][j - 1]);
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
    return safeAdd(dp[0][0][n - 1], dp[1][0][n - 1], dp[2][0][n - 1], dp[3][0][n - 1]);
  }

  private static final int safeAdd(int a, final int... arr) {
    int sum = a;
    for (int n : arr) {
      sum = (sum + n) % MOD;
    }
    return sum;
  }
}
