package interviews.byteDance._072_Edit_Distance;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minDistance(String word1, String word2) {
    final int m = word1.length(), n = word2.length();
    final int[][] dp = new int[m + 1][n + 1];
    for (int j = 0; j < n; ++j) {
      dp[0][j + 1] = j + 1;
    }
    for (int i = 0; i < m; ++i) {
      dp[i + 1][0] = dp[i][0] + 1;
      for (int j = 0; j < n; ++j) {
        dp[i + 1][j + 1] = dp[i][j] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);
        dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + 1, dp[i + 1][j + 1]);
        dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + 1, dp[i + 1][j + 1]);
      }
    }
    return dp[m][n];
  }
}
