package interviews.pinterest._010_Regular_Expression_Matching;

public class Solution {
  public boolean isMatch(String s, String p) {
    final boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
    dp[0][0] = true;

    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*') {
        dp[i + 1][0] = dp[i - 1][0];
      }

      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == p.charAt(i) || p.charAt(i) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (p.charAt(i) == '*') {
          dp[i + 1][j + 1] = dp[i - 1][j + 1] || ((p.charAt(i - 1) == '.' || s.charAt(j) == p.charAt(i - 1)) && dp[i + 1][j]);
        }
      }
    }
    return dp[p.length()][s.length()];
  }

}
