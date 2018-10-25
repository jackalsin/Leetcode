package interviews.linkedin._074_Search_a_2D_Matrix;

public final class SolutionI implements Solution {
  @Override
  public boolean searchMatrix(final int[][] matrix, final int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    int left = 0, right = rows * cols - 1;
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      final int row = mid / cols, col = mid % cols;
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
