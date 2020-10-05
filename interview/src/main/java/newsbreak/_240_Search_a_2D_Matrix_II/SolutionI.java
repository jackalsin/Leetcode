package newsbreak._240_Search_a_2D_Matrix_II;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    for (int row = 0, col = cols - 1; row < rows && col >= 0; ) {
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        row++;
      } else {
        col--;
      }
    }
    return false;
  }
}
