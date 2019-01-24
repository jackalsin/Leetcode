package interviews.airbnb._073_Set_Matrix_Zeroes;

/**
 * @author jacka
 * @version 1.0 on 1/24/2019.
 */
public class Solution {
  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    final int rows = matrix.length, cols = matrix[0].length;

    // if matrix[0][col] == 0 (col belongs to [0, cols - 1], this col should be set to zero
    // if matrix[row][0] == 0 (row belongs to [1, rows - 1], this row should be set to 0

    boolean shouldSetRow0To0 = false;
    for (int col = 0; col < cols; col++) {
      if (matrix[0][col] == 0) {
        shouldSetRow0To0 = true;
      }
    }

    // identify
    for (int row = 1; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == 0) {
          matrix[row][0] = 0;
          matrix[0][col] = 0;
        }
      }
    } // end of for row
//    display(matrix);

    for (int row = rows - 1; row >= 1; row--) {
      for (int col = cols - 1; col >= 0; col--) {
        if (matrix[row][0] == 0 || matrix[0][col] == 0) {
          matrix[row][col] = 0;
        }
      }
    }

//    display(matrix);
    if (shouldSetRow0To0) {
      for (int col = 0; col < cols; col++) {
        matrix[0][col] = 0;
      }
    }
  }
}
