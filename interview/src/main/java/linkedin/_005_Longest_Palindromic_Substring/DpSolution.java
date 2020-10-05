package linkedin._005_Longest_Palindromic_Substring;

public final class DpSolution implements Solution {
  @Override
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    final int n = s.length(), rows = n, cols = n;
    int maxLen = 0;
    String maxString = "";
    final boolean[][] dp = new boolean[n][n];
    for (int i = rows - 1; i >= 0; --i) {
      for (int j = i; j < cols; ++j) {
        if (j == i) {
          dp[i][j] = true;
        } else if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = i + 1 <= j - 1 ? dp[i + 1][j - 1] : true;
        }
        if (dp[i][j]) {
          maxLen = Math.max(maxLen, j - i + 1);
          maxString = s.substring(i, j + 1);
        }
      }
    }
    return maxString;
  }
}
