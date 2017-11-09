package _351_400._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
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
