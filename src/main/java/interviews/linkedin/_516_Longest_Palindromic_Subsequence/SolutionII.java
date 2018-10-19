package interviews.linkedin._516_Longest_Palindromic_Subsequence;

public final class SolutionII implements Solution {
  public int longestPalindromeSubseq(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    final int[][] dp = new int[s.length()][s.length()];
    for (int row = s.length() - 1; row >= 0; row--) {
      dp[row][row] = 1;
      for (int col = row + 1; col < s.length(); col++) {
        dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
        if (s.charAt(row) == s.charAt(col)) {
          dp[row][col] = Math.max(dp[row][col], dp[row + 1][col - 1] + 2);
        }
      }
    }
    return dp[0][s.length() - 1];
  }
}
