package interviews.airbnb._221_Maximal_Square;

/**
 * @author jacka
 * @version 1.0 on 1/31/2019.
 */
public class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final int[][] dp = new int[rows][cols];
    int max = 0;
    for (int col = 0; col < cols; col++) {
      dp[0][col] = matrix[0][col] - '0';
      max = Math.max(max, dp[0][col]);
    }
    for (int row = 1; row < rows; row++) {
      dp[row][0] = matrix[row][0] - '0';
      max = Math.max(max, dp[row][0]);
      for (int col = 1; col < cols; col++) {
        final char chr = matrix[row][col];
        if (chr == '1') {
          dp[row][col] = min(dp[row][col - 1] + 1, dp[row - 1][col] + 1, dp[row - 1][col - 1] + 1);
          max = Math.max(max, dp[row][col]);
        }
      }
    }
    return max * max;
  }

  private static int min(int a, int... bArray) {
    int res = a;
    for (int b : bArray) {
      res = Math.min(b, res);
    }
    return res;
  }
}
