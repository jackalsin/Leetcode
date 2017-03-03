package _001_050._044_Wildcard_Matching;

/**
 * @author jacka
 * @version 1.0 on 2/22/2017.
 */
public class Solution {

  /**
   *
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch(String s, String p) {
    if (s == null) {
      throw new NullPointerException();
    } else if (p == null) {
      throw new NullPointerException();
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*') {
        dp[0][i + 1] = true;
      } else {
        break;
      }
    }

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (p.charAt(j) == '*') {
          dp[i + 1][j + 1] = dp[i + 1][j] // a*b aa
                              || dp[i][j + 1]; // a*b acb
        } else {
          dp[i + 1][j + 1] = dp[i][j] // s.charAt(i) == s.charAt(j)
              && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
        }
      }
    }

    return dp[s.length()][p.length()];
  }

}
