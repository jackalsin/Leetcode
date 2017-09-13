package _301_350._304_Range_Sum_Query_2D_Immutable;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public final class NumMatrix {
  private final int[][] sum;
  public NumMatrix(int[][] matrix) {
    int rows = matrix.length;
    int cols = rows > 0 ? matrix[0].length : 0;
    sum = new int[rows][cols];
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        sum[row][col] = matrix[row][col] + (col == 0 ? 0:sum[row][col - 1]);
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int result = 0;
    for (int row = row1; row <= row2; ++row) {
      result += sum[row][col2] - (col1 == 0 ? 0 : sum[row][col1 - 1]);
    }
    return result;
  }
}
