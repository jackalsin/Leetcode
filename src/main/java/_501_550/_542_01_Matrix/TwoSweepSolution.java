package _501_550._542_01_Matrix;

/**
 * 48 / 48 test cases passed.
 * Status: Accepted
 * Runtime: 20 ms
 */
public final class TwoSweepSolution implements Solution {

  @Override
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return matrix;
    }
    final int rows = matrix.length, cols = matrix[0].length;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] != 0) {
          int top = Integer.MAX_VALUE - 1, left = Integer.MAX_VALUE - 1;
          if (row - 1 >= 0) top = matrix[row - 1][col];
          if (col - 1 >= 0) left = matrix[row][col - 1];
          matrix[row][col] = Math.min(Integer.MAX_VALUE - 1, Math.min(top, left) + 1);
        }
      }
    }
    for (int row = rows - 1; row >= 0; row--) {
      for (int col = cols - 1; col >= 0; col--) {
        if (matrix[row][col] != 0) {
          int bottom = Integer.MAX_VALUE - 1, right = Integer.MAX_VALUE - 1;
          if (row + 1 < rows) bottom = matrix[row + 1][col];
          if (col + 1 < cols) right = matrix[row][col + 1];
          matrix[row][col] = Math.min(matrix[row][col], Math.min(bottom, right) + 1);
        }
      }
    }
    return matrix;
  }
}
