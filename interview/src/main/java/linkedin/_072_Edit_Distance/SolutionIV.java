package linkedin._072_Edit_Distance;

/**
 * @author jacka
 * @version 1.0 on 10/2/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) return 0;
    final int m = word1.length(), n = word2.length();
    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < n; ++i) {
      dp[0][i + 1] = i + 1;
    }
    for (int i = 0; i < m; ++i) {
      dp[i + 1][0] = i + 1;
      for (int j = 0; j < n; ++j) {
        dp[i + 1][j + 1] = 1 + min(dp[i + 1][j], dp[i][j + 1], dp[i][j]);
        if (word1.charAt(i) == word2.charAt(j)) {
          dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
        }
      }
    }
    return dp[m][n];
  }

  private static int min(final int a, final int... b) {
    int res = a;
    for (int c : b) res = Math.min(res, c);
    return res;
  }
}
