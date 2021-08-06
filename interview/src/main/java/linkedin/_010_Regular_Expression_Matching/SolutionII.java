package linkedin._010_Regular_Expression_Matching;

public final class SolutionII implements Solution {
  @Override
  public boolean isMatch(String s, String p) {
    final int sLen = s.length(), pLen = p.length();
    final boolean[][] dp = new boolean[sLen + 1][pLen + 1];
    dp[0][0] = true;
    final char[] sChars = s.toCharArray(), pChars = p.toCharArray();
    for (int i = 0; i < pLen; ++i) {
      if (pChars[i] == '*') dp[0][i + 1] |= dp[0][i - 1];
    }
    for (int i = 0; i < sLen; ++i) {
      final char sChar = sChars[i];
      for (int j = 0; j < pLen; ++j) {
        final char pChar = pChars[j];
        if (sChar == pChar || pChar == '.') {
          dp[i + 1][j + 1] |= dp[i][j];
        } else if (pChar == '*') {
          dp[i + 1][j + 1] |= dp[i + 1][j - 1]; // 0
          if (pChars[j - 1] == sChar || pChars[j - 1] == '.') {
            dp[i + 1][j + 1] |= dp[i + 1][j]; // 1
            dp[i + 1][j + 1] |= dp[i][j + 1]; // multiple
          }
        }
      }
    }
    return dp[sLen][pLen];
  }
}
