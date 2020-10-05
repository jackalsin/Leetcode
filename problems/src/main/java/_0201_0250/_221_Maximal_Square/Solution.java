package _0201_0250._221_Maximal_Square;

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
    /*其实这题跟hight计算没关系，直接dp[i][j] denotes the max side length that can form a square whose right bottom is [i, j]*/
//    return twoDArraySolution(matrix);
    return oneArraySolution(matrix);
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

    final int[] dp = new int[cols];
    int maxArea = 0;
    // first row
    for (int col = 0; col < cols; ++col) {
      dp[col] = matrix[0][col] - '0';
      maxArea = Math.max(maxArea, dp[col] * dp[col]);
    }
    // start second row
    for (int row = 1; row < rows; ++row) {
      int triangle = dp[0];
      dp[0] = matrix[row][0] - '0';
      maxArea = Math.max(maxArea, dp[0] * dp[0]);
      for (int col = 1; col < cols; ++col) {
        int tmp = dp[col];
        if (matrix[row][col] == '0') {
          dp[col] = 0;
          maxArea = Math.max(maxArea, dp[col] * dp[col]);
        } else { // == '1'
          int min = Math.min(Math.min(dp[col - 1], dp[col]), triangle);
          dp[col] = min + 1;
          maxArea = Math.max(maxArea, dp[col] * dp[col]);
        }
        triangle = tmp;
      }
    }
    return maxArea;
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
