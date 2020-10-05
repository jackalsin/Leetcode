package linkedin._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 6/25/2019
 */
public final class DpSolutionI implements Solution {
  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    final int n = s.length();
    final boolean[][] dp = new boolean[n][n];
    String maxString = "";
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if (j == i) {
          dp[i][j] = true;
        } else if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = i + 1 >= j - 1 || dp[i + 1][j - 1];
        }
        if (dp[i][j] && j - i + 1 >= maxString.length()) {
          maxString = s.substring(i, j + 1);
        }
      }
    }
    return maxString;
  }
}
