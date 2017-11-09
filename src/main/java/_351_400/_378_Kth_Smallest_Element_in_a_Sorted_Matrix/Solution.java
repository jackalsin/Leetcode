package _351_400._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
//    return nLogNSolution(matrix, k);
    return logNSolution(matrix, k);
  }

  /**
   * This solution is O(N * log (Max - Min))
   *
   * @param matrix
   * @param k
   * @return
   */
  private int logNSolution(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1];
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int count = getLessThanOrEquals(matrix, mid);
      if (count < k) { // if equals, low will increase, then mid + 1 will miss.
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return lo;
  }

  private static int getLessThanOrEquals(final int[][] matrix, final int val) {
    final int rows = matrix.length, cols = matrix[0].length;
    int count = 0, j = cols - 1;
    for (int i = 0; i < rows; i++) {
      while (j >= 0 && matrix[i][j] > val) j--; // j stops at 0 or just smaller
      count += (j + 1);
    }
    return count;
  }

  private int nLogNSolution(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) { // {value, index}
        return Integer.compare(o1[0], o2[0]);
      }
    });
    for (int i = 0; i < rows && i < k; i++) {
      pq.add(new int[]{matrix[i][0], i, 0});
    }
    while (k-- > 1) {
      final int[] curPair = pq.remove();
      final int curRow = curPair[1];
      final int curCol = curPair[2];
      if (curCol != cols - 1) {
        pq.add(new int[]{matrix[curRow][curCol + 1], curRow, curCol + 1});
      }
    }
    return pq.peek()[0];
  }
}
