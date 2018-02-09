package interviews.uber._010_Regular_Expression_Matching;

public class Solution {
  public boolean isMatch(String s, String p) {
    final boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;

    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*' && dp[0][i - 1]) { // for example, a*bc
        dp[0][i + 1] = true;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (s.charAt(i) == p.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (p.charAt(j) == '*') {
          assert j != 0;
          if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
            dp[i + 1][j + 1] = dp[i + 1][j - 1] // match empty
                || dp[i + 1][j] // match one
                || dp[i][j + 1]; // match multiple
          } else {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          }
        } else {
          dp[i + 1][j + 1] = false;
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}
