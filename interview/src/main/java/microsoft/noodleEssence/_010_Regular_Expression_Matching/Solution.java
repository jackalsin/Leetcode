package microsoft.noodleEssence._010_Regular_Expression_Matching;

public class Solution {
  public boolean isMatch(String s, String p) {
    final boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*') {
        dp[0][i + 1] = dp[0][i - 1];
      }
    }

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        final char pChar = p.charAt(j), sChar = s.charAt(i);
        if (pChar == sChar || pChar == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (pChar == '*') {
          //                match zero
          dp[i + 1][j + 1] |= dp[i + 1][j - 1];
          //   (p.charAt(j - 1) == '.' || )
          if (p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)) {
            dp[i + 1][j + 1] |= dp[i + 1][j]; // match 1
            dp[i + 1][j + 1] |= dp[i][j + 1]; // match many

          }
        }
      }
    }

    return dp[s.length()][p.length()];
  }
}
