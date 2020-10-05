package explore._221_Maximal_Square;

/**
 * @author jacka
 * @version 1.0 on 4/27/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int m = matrix.length, n = matrix[0].length;
    final int[][] dp = new int[m + 1][n + 1];
    int max = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (matrix[i][j] == '1') {
          dp[i + 1][j + 1] = max(1, min(dp[i][j], dp[i][j + 1], dp[i + 1][j]) + 1);
          max = Math.max(dp[i + 1][j + 1], max);
        }
      }
    }
    return max * max;
  }

  private static int min(int a, final int... b) {
    for (int c : b) {
      a = Math.min(a, c);
    }
    return a;
  }

  private static int max(int a, final int... b) {
    for (int c : b) {
      a = Math.max(a, c);
    }
    return a;
  }
}
