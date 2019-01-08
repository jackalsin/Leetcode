package interviews.uber._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

public final class LogNSolution implements Solution {
  public int kthSmallest(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    final int N = matrix.length;
    int lo = matrix[0][0], hi = matrix[N - 1][N - 1];
    while (lo < hi) {
      final int mid = lo + (hi - lo) / 2;
      int count = getLessThanOrEquals(matrix, mid);
//      if (count == k) {
//        return mid;
//      } else if (count < k) {
//        lo = mid + 1;
//      } else {
//        hi = mid - 1;
//      }

      if (count < k) {
        lo = mid + 1;
      } else if (count == k) {
        hi = mid;
      } else {
        hi = mid;
      }
    }
    return lo;
  }

  private static int getLessThanOrEquals(int[][] matrix, int target) {
    final int N = matrix.length;
    int j = N - 1, count = 0;
    for (int row = 0; row < N; row++) {
      while (j >= 0 && matrix[row][j] > target) j--;
      count += j + 1;
    }
    return count;
  }

}
