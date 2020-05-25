package explore._1035_Uncrossed_Lines;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxUncrossedLines(int[] A, int[] B) {
    final int m = A.length, n = B.length;
    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        dp[i + 1][j + 1] = dp[i][j] + (A[i] == B[j] ? 1 : 0);
        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i + 1][j]);
        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
      }
    }
    return dp[m][n];
  }
}
