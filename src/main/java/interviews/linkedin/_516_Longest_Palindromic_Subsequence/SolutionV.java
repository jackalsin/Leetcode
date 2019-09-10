package interviews.linkedin._516_Longest_Palindromic_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 9/9/2019
 */
public final class SolutionV implements Solution {
  @Override
  public int longestPalindromeSubseq(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    final int n = s.length();
    final int[][] dp = new int[n][n];
    for (int i = n - 1; i >= 0; --i) {
      dp[i][i] = 1;
      final char iChar = s.charAt(i);
      for (int j = i + 1; j < n; ++j) {
        final char jChar = s.charAt(j);
        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + (iChar == jChar ? 2 : 0));
        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
      }
    }
    return dp[0][n - 1];
  }
}

