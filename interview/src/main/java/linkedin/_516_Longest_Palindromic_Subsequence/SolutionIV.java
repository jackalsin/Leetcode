package linkedin._516_Longest_Palindromic_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 7/25/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int longestPalindromeSubseq(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    final int[][] dp = new int[s.length()][s.length()];
    final char[] chars = s.toCharArray();
    for (int i = s.length() - 1; i >= 0; i--) {
      dp[i][i] = 1;
      for (int j = i + 1; j < s.length(); j++) {
        final char iChar = chars[i], jChar = chars[j];
        dp[i][j] = dp[i + 1][j - 1] + (iChar == jChar ? 2 : 0);
        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
      }
    }
    return dp[0][s.length() - 1];
  }
}
