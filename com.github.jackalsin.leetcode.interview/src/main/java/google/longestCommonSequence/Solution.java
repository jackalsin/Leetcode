package google.longestCommonSequence;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public final class Solution {
  public String longestCommonSequence(final String a, final String b) {
    final int[][] dp = new int[a.length() + 1][b.length() + 1];
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < b.length(); j++) {
        if (a.charAt(i) == b.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
      }
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < b.length(); i++) {
      if (dp[a.length()][i + 1] != dp[a.length()][i]) {
        sb.append(b.charAt(i));
      }
    }
    return sb.toString();
  }
}
