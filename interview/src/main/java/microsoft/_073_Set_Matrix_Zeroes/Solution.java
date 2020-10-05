package microsoft._073_Set_Matrix_Zeroes;

import java.util.Arrays;

public class Solution {
  public void setZeroes(int[][] matrix) {
    int row0 = 1, col0 = 1;
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    if (matrix[0][0] == 0) {
      row0 = 0;
      col0 = 0;
    }
    for (int col = 1; col < cols; col++) {
      if (matrix[0][col] == 0) {
        row0 = 0;
        break;
      }
    }
    for (int row = 1; row < rows; row++) {
      if (matrix[row][0] == 0) {
        col0 = 0;
      }
      for (int col = 1; col < cols; col++) {
        if (matrix[row][col] == 0) {
          matrix[0][col] = 0;
          matrix[row][0] = 0;
        }
      }
    }

    for (int row = 1; row < rows; row++) {
      for (int col = 1; col < cols; col++) {
        if (matrix[0][col] == 0 || matrix[row][0] == 0) {
          matrix[row][col] = 0;
        }
      }
    }

    if (row0 == 0) {
      Arrays.fill(matrix[0], 0);
    }

    if (col0 == 0) {
      for (int row = 0; row < rows; row++) {
        matrix[row][0] = 0;
      }
    }
  }
}
