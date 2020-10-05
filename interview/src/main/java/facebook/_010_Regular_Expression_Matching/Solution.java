package facebook._010_Regular_Expression_Matching;

public class Solution {
  public boolean isMatch(String s, String p) {
    final boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
      final char chr = p.charAt(i);
      if (chr == '*') {
        dp[0][i + 1] = dp[0][i - 1];
      }
    }

    for (int i = 0; i < s.length(); i++) {
      final char sChar = s.charAt(i);
      for (int j = 0; j < p.length(); j++) {
        final char pChar = p.charAt(j);
        if (pChar == '*') {
          dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] ||
              ((p.charAt(j - 1) == '.' || sChar == p.charAt(j - 1)) && dp[i][j + 1]);
        } else if (pChar == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (sChar == pChar) {
          dp[i + 1][j + 1] = dp[i][j];
        }
      }
    }
//    TwoDimensionArray.display2DimensionArray(dp);
    return dp[s.length()][p.length()];
  }
}
