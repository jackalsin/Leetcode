package _0201_0250._240_Search_a_2D_Matrix_II;

/**
 * @author jacka
 * @version 1.0 on 8/20/2017.
 */
public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return false;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    int row = 0, col = cols - 1;
    while (col >= 0 && row < rows) {
      if (target == matrix[row][col]) {
        return true;
      } else if (matrix[row][col] < target) {
        row++;
      } else if (matrix[row][col] > target) {
        col--;
      }
    }
    return false;
  }
}
