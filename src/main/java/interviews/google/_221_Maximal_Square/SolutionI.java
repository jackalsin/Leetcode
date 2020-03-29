package interviews.google._221_Maximal_Square;

/**
 * @author jacka
 * @version 1.0 on 3/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] dp = new int[rows][cols];
    int max = 0;
    for (int i = 0; i < cols; ++i) {
      if (matrix[0][i] == '1') {
        dp[0][i] = 1;
        max = 1;
      }
    }
    for (int row = 1; row < rows; row++) {
      if (matrix[row][0] == '1') {
        dp[row][0] = 1;
        max = Math.max(max, 1);
      }
      for (int col = 1; col < cols; ++col) {
        if (matrix[row][col] == '1') {
          final int side = min(dp[row - 1][col], dp[row][col - 1], dp[row - 1][col - 1]) + 1;
          max = Math.max(max, side * side);
          dp[row][col] = side;
        }
      }
    }
    return max;
  }

  private static int min(int a, final int... b) {
    for (int c : b) {
      a = Math.min(a, c);
    }
    return a;
  }
}
