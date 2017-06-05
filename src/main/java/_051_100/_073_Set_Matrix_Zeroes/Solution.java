package _051_100._073_Set_Matrix_Zeroes;

/**
 * @author jacka
 * @version 1.0 on 4/29/2017.
 */
public class Solution {

  public void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    if (rows == 0) return;
    int cols = matrix[0].length;
    int col0 = 1; // col0 value, matrix[0][0] only stands for the row
    for(int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (col == 0 && matrix[row][col] == 0) {
          col0 = 0;
        } else if (matrix[row][col] == 0) {
          matrix[0][col] = 0;
          matrix[row][0] = 0;
        }
      }
    }

    for (int row = rows- 1; row >= 0; row--) {
      for (int col = cols - 1; col >= 0; col--) {
        if (col == 0) {
          if (col0 == 0) {
            matrix[row][0] = 0;
          }
        } else if (matrix[row][0] == 0 || matrix[0][col] == 0) {
          matrix[row][col] = 0;
        }
      }
    }

    /* Better solution */
    /*for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 1; j--)
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;
      if (col0 == 0) matrix[i][0] = 0;
    }*/
  }
}
