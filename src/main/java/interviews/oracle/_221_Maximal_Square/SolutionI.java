package interviews.oracle._221_Maximal_Square;

/**
 * @author jacka
 * @version 1.0 on 10/15/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] dp = new int[rows][cols];
    int maxSide = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (i == 0 || j == 0 || matrix[i][j] == '0') {
          dp[i][j] = matrix[i][j] - '0';
        } else {
          dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
        }
        maxSide = Math.max(maxSide, dp[i][j]);
      }
    }
    return maxSide * maxSide;
  }

  private static int min(int a, final int... b) {
    for (int c : b) {
      a = Math.min(a, c);
    }
    return a;
  }
}
