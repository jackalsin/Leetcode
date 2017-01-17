package _001_100._010_Regular_Expression_Matching;

/**
 * Key to think is the way we treat "a*".
 *
 * @author jacka
 * @version 1.0 on 2017/1/15.
 */
public class Solution {

  /**
   * Implement regular expression matching with support for '.' and '*'.
   *
   * @param s string
   * @param p pattern
   * @return true if s matches the pattern, otherwise return false.
   */
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    // empty string match p ?
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*' && dp[0][i - 1]) {
        dp[0][i + 1] = true;
      }
    }

    // compare starts with 1;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (s.charAt(i) == p.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
            dp[i + 1][j + 1] = dp[i + 1][j] // a* is a
                || dp[i][j + 1] // a* is multiple a
                || dp[i + 1][j - 1]; // a* is empty
          } else {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          }
        }
      }
    }

    return dp[s.length()][p.length()];
  }
}
