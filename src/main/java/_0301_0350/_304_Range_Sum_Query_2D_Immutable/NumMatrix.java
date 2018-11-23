package _0301_0350._304_Range_Sum_Query_2D_Immutable;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public final class NumMatrix {
  private final int[][] sum;

  public NumMatrix(int[][] matrix) {
    int rows = matrix.length;
    int cols = rows > 0 ? matrix[0].length : 0;
    sum = new int[rows + 1][cols + 1];
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        sum[row + 1][col + 1] = sum[row][col + 1] + sum[row + 1][col] - sum[row][col] +
            matrix[row][col];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sum[row2 + 1][col2 + 1] + sum[row1][col1] - sum[row2 + 1][col1] -
        sum[row1][col2 + 1];
  }
}
