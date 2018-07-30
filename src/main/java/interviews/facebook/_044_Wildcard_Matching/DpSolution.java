package interviews.facebook._044_Wildcard_Matching;

public final class DpSolution implements Solution {
  public boolean isMatch(String s, String p) {
    final boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;

    for (int i = 0; i < p.length(); i++) {
      dp[0][i + 1] = (p.charAt(i) == '*') && dp[0][i];
    }

    for (int i = 0; i < s.length(); i++) {
      final char sChar = s.charAt(i);
      for (int j = 0; j < p.length(); j++) {
        final char pChar = p.charAt(j);
        if (pChar == '*') {
          //                 match 1     match multiple  match 0
          dp[i + 1][j + 1] = dp[i][j] || dp[i][j + 1] || dp[i + 1][j];
        } else if (pChar == sChar) {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (pChar == '?') {
          dp[i + 1][j + 1] = dp[i][j];
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}
