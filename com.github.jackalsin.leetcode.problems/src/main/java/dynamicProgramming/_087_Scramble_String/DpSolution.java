package dynamicProgramming._087_Scramble_String;

public final class DpSolution implements Solution {
  // TODO: Revisit
  public boolean isScramble(String s1, String s2) {
    assert (s1.length() == s2.length());
    final int len = s1.length();
    if (len == 0) {
      return true;
    } else if (len == 1) {
      return s1.charAt(0) == s2.charAt(0);
    }

    final boolean[][][] dp = new boolean[len + 1][len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          dp[1][i][j] = true;
        }
      }
    }

    for (int l = 2; l <= len; l++) {
      for (int i = 0; i <= len - l; i++) {
        for (int j = 0; j <= len - l; j++) {
          for (int k = 1; k < l; k++) {

            dp[l][i][j] |= (dp[k][i][j] && dp[l - k][i + k][j + k]);
            dp[l][i][j] |= (dp[k][i + l - k][j] && dp[l - k][i][j + k]);
            if (dp[l][i][j]) {
              break;
            }
          }
        }
      }
    }

    return dp[len][0][0];

  }

}
