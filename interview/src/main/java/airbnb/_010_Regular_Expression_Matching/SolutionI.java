package airbnb._010_Regular_Expression_Matching;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
public final class SolutionI implements Solution {
  private static final char DOT = '.', ASTERISK = '*';

  public boolean isMatch(String s, String p) {
    if (s == null || p == null) return true;
    final int m = s.length(), n = p.length();
    final boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 0; i < n; ++i) {
      if (p.charAt(i) == ASTERISK) dp[0][i + 1] = dp[0][i - 1];
    }
    for (int i = 0; i < m; ++i) {
      final char sChar = s.charAt(i);
      for (int j = 0; j < n; ++j) {
        final char pChar = p.charAt(j);
        if (pChar == sChar || pChar == DOT) {
          dp[i + 1][j + 1] |= dp[i][j];
        } else if (pChar == ASTERISK) {
          dp[i + 1][j + 1] |= dp[i + 1][j - 1]; // a* matches 0
          if (p.charAt(j - 1) == sChar || p.charAt(j - 1) == DOT) {
            dp[i + 1][j + 1] |= dp[i + 1][j]; // a* matches 1
            dp[i + 1][j + 1] |= dp[i][j + 1]; // a* matches multiple
          }
        }
      }
    }
    return dp[m][n];
  }
}
