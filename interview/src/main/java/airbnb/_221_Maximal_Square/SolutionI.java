package airbnb._221_Maximal_Square;

/**
 * @author zhixi
 * @version 1.0 on 8/24/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) return 0;
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] dp = new int[rows + 1][cols + 1];
    int max = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (matrix[row][col] == '1') {
          if (row > 0 && col > 0) {
            dp[row + 1][col + 1] = 1 + min(dp[row][col], dp[row + 1][col], dp[row][col + 1]);
          } else {
            dp[row + 1][col + 1] = 1;
          }
        } else {
          dp[row + 1][col + 1] = 0;
        }
        max = Math.max(max, dp[row + 1][col + 1]);
      }
    }
    return max * max;
  }

  private static int min(int a, final int... b) {
    for (int c : b) {
      a = Math.min(c, a);
    }
    return a;
  }
}
