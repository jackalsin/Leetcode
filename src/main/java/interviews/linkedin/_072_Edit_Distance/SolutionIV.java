package interviews.linkedin._072_Edit_Distance;

/**
 * @author jacka
 * @version 1.0 on 10/2/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) {
      return 0;
    }
    final int m = word1.length(), n = word2.length();
    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < n; i++) {
      dp[0][i + 1] = i + 1;
    }
    for (int i = 0; i < m; ++i) {
      dp[i + 1][0] = i + 1;
      final char iChar = word1.charAt(i);
      for (int j = 0; j < n; ++j) {
        final char jChar = word2.charAt(j);
        dp[i + 1][j + 1] = dp[i][j] + (iChar == jChar ? 0 : 1);
        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j + 1] + 1);
        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 1][j] + 1);
      }
    }
    return dp[m][n];
  }
}
