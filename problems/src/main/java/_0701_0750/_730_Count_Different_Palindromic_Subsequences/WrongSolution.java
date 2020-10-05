package _0701_0750._730_Count_Different_Palindromic_Subsequences;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class WrongSolution implements Solution {
  private static final int BASE = (int) 1E9 + 7;

  public int countPalindromicSubsequences(String s) {
    if (s == null) {
      return 0;
    }
    final int n = s.length();
    final char[] chars = s.toCharArray();
    final int[][] dp = new int[n][n];
    for (int i = n - 1; i >= 0; --i) {
      dp[i][i] = 1;
      for (int j = i + 1; j < n; ++j) {
        if (chars[i] == chars[j]) dp[i][j] = dp[i + 1][j - 1];
        dp[i][j] = safeAdd(dp[i][j], dp[i + 1][j], dp[i][j - 1]);
      }
    }
    return dp[0][n - 1];
  }

  private static int safeAdd(final int a, final int... b) {
    int res = a;
    for (int c : b) {
      res = (res + c) % BASE;
    }
    return res;
  }
}
