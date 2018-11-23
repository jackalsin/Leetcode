package _0001_0050._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 1/11/2017.
 */
public final class DpSolution implements Solution {
  @Override
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    final boolean[][] dp = new boolean[s.length()][s.length()];
    String res = "";

    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = i; j < s.length(); j++) {
        dp[i][j] = (2 >= j - i || dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));

        if (dp[i][j] && (j - i + 1) > res.length()) {
          res = s.substring(i, j + 1);
        }
      }
    }
    return res;
  }
}
