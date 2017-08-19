package _201_250._221_Maximal_Square;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/15/2017.
 */
public class Solution {
  /**
   * Return the <strong>square</strong> area in the matrix.
   *
   * @param matrix
   * @return
   */
  public int maximalSquare(char[][] matrix) {
    return twoDArraySolution(matrix);
//    return oneArraySolution(matrix);
  }

  private int oneArraySolution(char[][] matrix) {
    if (matrix == null) {
      throw new NullPointerException("matrix shouldn't be null");
    }
    int rows = matrix.length;
    if (rows == 0) {
      return 0;
    }
    int cols = matrix[0].length;
    if (cols == 0) {
      return 0;
    }
    //Todo:

    return 0;
  }

  private int twoDArraySolution(char[][] matrix) {
    if (matrix == null) {
      throw new NullPointerException("matrix shouldn't be null");
    }
    int rows = matrix.length;
    if (rows == 0) {
      return 0;
    }
    int cols = matrix[0].length;
    if (cols == 0) {
      return 0;
    }
    int maxArea = 0;
    final int[][] dp = new int[rows][cols];
    for (int col = 0; col < cols; ++col) {
      dp[0][col] = matrix[0][col] - '0';
      maxArea = Math.max(maxArea, dp[0][col] * dp[0][col]);
    }

    for (int row = 1; row < rows; row++) {
      dp[row][0] = matrix[row][0] - '0';
      maxArea = Math.max(maxArea, dp[row][0] * dp[row][0]);
      for (int col = 1; col < cols; ++col) {
        if (matrix[row][col] == '0') {
          dp[row][col] = 0;
        } else { // == '1'
          int min = Math.min(Math.min(dp[row - 1][col - 1], dp[row - 1][col]), dp[row][col - 1]);
          dp[row][col] = min + 1;
          maxArea = Math.max(maxArea, dp[row][col] * dp[row][col]);
        }
      }
    }
    return maxArea;
  }
}
