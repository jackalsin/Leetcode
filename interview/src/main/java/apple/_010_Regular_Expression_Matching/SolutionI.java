package apple._010_Regular_Expression_Matching;

/**
 * @author jacka
 * @version 1.0 on 2/13/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isMatch(String s, String p) {
    final int m = s.length(), n = p.length();
    final boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 0; i < n; i++) {
      if (p.charAt(i) == '*') {
        dp[0][i + 1] = dp[0][i - 1];
      }
    }
    for (int i = 0; i < m; ++i) {
      final char sChar = s.charAt(i);
      for (int j = 0; j < n; ++j) {
        final char pChar = p.charAt(j);
        if (sChar == pChar || pChar == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (pChar == '*') {
          dp[i + 1][j + 1] = dp[i + 1][j - 1];
          if ((p.charAt(j - 1) == sChar
              || p.charAt(j - 1) == '.')) {
            dp[i + 1][j + 1] |= // a* matches
                dp[i][j] // match 1
                    || dp[i][j + 1]; // match more
          }
        }
      }
    }
    return dp[m][n];
  }
}
