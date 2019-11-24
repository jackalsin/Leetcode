package interviews.oracle._221_Maximal_Square;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] dp = new int[rows + 1][cols + 1];
    int maxSide = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (matrix[i][j] == '0') {
          continue;
        }
        dp[i + 1][j + 1] = min(dp[i][j], dp[i + 1][j], dp[i][j + 1]) + 1;
        maxSide = Math.max(dp[i + 1][j + 1], maxSide);
      }
    }
    return maxSide * maxSide;
  }

  private static int min(int a, int... b) {
    for (int c : b) {
      a = Math.min(c, a);
    }
    return a;
  }
}
