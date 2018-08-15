package interviews.microsoft.noodleEssence._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

public final class BinarySearchSolution implements Solution {

  @Override
  public int kthSmallest(int[][] matrix, int k) {
    final int n = matrix.length;
    int left = matrix[0][0], right = matrix[n - 1][n - 1];

    while (left < right) { // check if equals
      final int mid = (right - left) / 2 + left,
          count = getCounts(matrix, mid);

      // Key Point 1: find the first number that satisfies count >= k
      if (count >= k) {
        right = mid;
      } else { // count > k
        left = mid + 1;
      }
    }
    return left; // possible throw error
  }

  /**
   * Count the number less than or equals to
   *
   * @param matrix
   * @param mid
   * @return
   */
  private static int getCounts(int[][] matrix, int mid) {
    int count = 0, n = matrix.length, right = matrix.length - 1;
    for (int row = 0; row < n; row++) {
      while (right >= 0 && matrix[row][right] > mid) {
        right--;
      }
      if (right < 0) break;
      count += right + 1;
    }
    return count;
  }
}
