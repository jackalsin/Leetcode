package uber.radius;

/**
 * @author jacka
 * @version 1.0 on 4/16/2021
 */

public final class SolutionI implements Solution {
  @Override
  public int maxSum(int[][] matrix, int r) {
    final int rows = matrix.length, cols = matrix[0].length;
    int max = 0;
    for (int centerRow = r - 1; centerRow + r <= rows; ++centerRow) {
      for (int centerCol = r - 1; centerCol + r <= cols; ++centerCol) {
        int cur = getSum(matrix, r, centerRow, centerCol);
        max = Math.max(cur, max);
      }
    }
    return max;
  }

  private int getSum(final int[][] matrix, final int r, final int centerRow, final int centerCol) {
    int res = 0;
    int startCol = centerCol, endCol = centerCol;
    for (int row = centerRow - (r - 1); row <= centerRow + (r - 1); row++) {
      for (int col = startCol; col <= endCol; ++col) {
        res += matrix[row][col];
      }
      if (row < centerRow) {
        startCol--;
        endCol++;
      } else {
        startCol++;
        endCol--;
      }
    }
    return res;
  }
}
