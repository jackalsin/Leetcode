package _651_700._668_Kth_Smallest_Number_in_Multiplication_Table;

public class Solution {

  public int findKthNumber(int m, int n, int k) {
    final int[][] matrix = getMatrix(m, n);
//    TwoDimensionArray.display2DimensionArray(matrix);
    int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
    while (lo <= hi) {
      int mid = (hi - lo) / 2 + lo;
      int count = 0, j = n - 1;
      for (int row = 0; row < m && matrix[row][0] <= mid; row++) {
        while (j >= 0 && matrix[row][j] > mid) {
          j--;
        }
        count += (j + 1);
      }
      // 因为是小于等于mid 的count， count == k时，仍有可能是mid > target value, 因为此处mid不一定是存在于matrix中
      if (count >= k) {
        hi = mid - 1;
      } else if (count < k) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return lo;
  }

  private static int[][] getMatrix(final int rows, final int cols) {
    final int[][] result = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      result[row][0] = row + 1;
      for (int col = 1; col < cols; col++) {
        result[row][col] = result[row][0] * (col + 1);
      }
    }
    return result;
  }
}
