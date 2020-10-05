package linkedin.mianjing._005_Longest_Palindromic_Substring;

public final class DpSolution implements Solution {
  /**
   * Time Complexity: O(N ^ 2)
   * Space Complexity: O(N ^ 2)
   *
   * @param s
   * @return
   */
  @Override
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    final boolean[][] dp = new boolean[s.length()][s.length()];
    int maxLen = 0, left = 0;
    for (int row = s.length() - 1; row >= 0; --row) {
      for (int col = row; col < s.length(); ++col) {
        if (row == col) {
          dp[row][col] = true;
        } else if (col == row + 1) {
          dp[row][col] = s.charAt(row) == s.charAt(col);
        } else {
          dp[row][col] = dp[row + 1][col - 1] && s.charAt(row) == s.charAt(col);
        }
        if (dp[row][col]) {
          final int curLen = col - row + 1;
          if (curLen > maxLen) {
            left = row;
            maxLen = curLen;
          }
        }
      }
    }
    return s.substring(left, left + maxLen);
  }
}
