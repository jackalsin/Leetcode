package byteDance._010_Regular_Expression_Matching;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isMatch(String s, String p) {
    final boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int j = 0; j < p.length(); ++j) {
      if (p.charAt(j) == '*') {
        dp[0][j + 1] = dp[0][j - 1];
      }
    }
    for (int i = 0; i < s.length(); ++i) {
      final char sChar = s.charAt(i);
      for (int j = 0; j < p.length(); ++j) {
        final char pChar = p.charAt(j);
        if (sChar == pChar || p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (pChar == '*') {
          dp[i + 1][j + 1] |= dp[i + 1][j - 1]; // match zero
          if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
            dp[i + 1][j + 1] |= dp[i + 1][j] // match one
                || dp[i][j + 1]; // match multiple
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}
