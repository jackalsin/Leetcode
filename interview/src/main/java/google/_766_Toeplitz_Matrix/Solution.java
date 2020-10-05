package google._766_Toeplitz_Matrix;

/**
 * @author jacka
 * @version 1.0 on 1/25/2018.
 */
public class Solution {
  public boolean isToeplitzMatrix(int[][] matrix) {
    final int rows = matrix.length, cols = matrix[0].length;
    for (int row = 1; row < rows; row++) {
      for (int col = 1; col < cols; col++) {
        if (matrix[row - 1][col - 1] != matrix[row][col]) {
          return false;
        }
      }
    }
    return true;
  }
}
