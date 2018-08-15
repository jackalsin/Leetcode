package interviews.microsoft.noodleEssence._073_Set_Matrix_Zeroes;

import java.util.Arrays;

public class Solution {
  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    boolean zeroRow = matrix[0][0] == 0;
    final int rows = matrix.length, cols = matrix[0].length;
    for (int col = 0; col < cols; col++) {
      zeroRow |= matrix[0][col] == 0;
    }

    for (int row = 1; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == 0) {
          matrix[row][0] = 0;
          matrix[0][col] = 0;
        }
      }
    } // end of for loop


    for (int row = 1; row < rows; row++) {
      for (int col = cols - 1; col >= 0; col--) {
        if (matrix[0][col] == 0 || matrix[row][0] == 0) {
          matrix[row][col] = 0;
        }
      }
    }
    if (zeroRow) {
      Arrays.fill(matrix[0], 0);
    }

  }

}
