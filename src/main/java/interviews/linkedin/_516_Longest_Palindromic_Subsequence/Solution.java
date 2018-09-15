package interviews.linkedin._516_Longest_Palindromic_Subsequence;

public class Solution {
  // TODO: revisit
  public int longestPalindromeSubseq(String s) {
    // dp[i][j] s[i ... j] longest subseq

    if (s == null || s.length() == 0) {
      return 0;
    }
    final int rows = s.length(), cols = s.length();
    final int[][] dp = new int[rows][cols];

    for (int row = rows - 1; row >= 0; --row) {
      dp[row][row] = 1;
      for (int col = row + 1; col < cols; ++col) {
        dp[row][col] = dp[row + 1][col - 1];
        if (s.charAt(row) == s.charAt(col)) {
          dp[row][col] += 2;
        } else {
          dp[row][col] = Math.max(dp[row][col], dp[row + 1][col]);
          dp[row][col] = Math.max(dp[row][col], dp[row][col - 1]);
        }
      }
    }
//    TwoDimensionArray.display(dp);
    return dp[0][rows - 1];
  }
}
