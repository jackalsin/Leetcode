package _1401_1450._1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;


import java.util.PriorityQueue;
import java.util.Queue;

public final class SolutionI implements Solution {
  /**
   * Time Complexity: O()
   */
  @Override
  public int kthSmallest(int[][] mat, int K) {
    // {val, row, col}
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    final int rows = mat.length, cols = mat[0].length;
    // O(n * log K)
    for (int col = 0; col < Math.min(cols, K); ++col) {
      pq.add(mat[0][col]);
      if (pq.size() > K) pq.remove();
    }
    for (int row = 1; row < rows; ++row) {
      final Queue<Integer> nextPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
      while (!pq.isEmpty()) {
        final int toRemove = pq.remove();
        for (int col = 0; col < Math.min(cols, K); ++col) {
          nextPq.add(toRemove + mat[row][col]);
          if (nextPq.size() > K) nextPq.remove();
        }
      }
      pq = nextPq;
    }
    assert !pq.isEmpty();
    return pq.peek();
  }
}
