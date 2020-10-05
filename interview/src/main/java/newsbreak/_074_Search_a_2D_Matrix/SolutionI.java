package newsbreak._074_Search_a_2D_Matrix;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    long left = 0, right = rows * cols - 1;
    while (left <= right) {
      final long mid = (left + right) / 2;
      final int row = (int) (mid / cols), col = (int) (mid % cols);
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
