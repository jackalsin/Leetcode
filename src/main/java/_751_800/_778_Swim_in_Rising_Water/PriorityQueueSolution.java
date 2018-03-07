package _751_800._778_Swim_in_Rising_Water;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
public final class PriorityQueueSolution implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  /**
   * Time Complexity O(N^2 * LogN)
   * 41 / 41 test cases passed.
   * Status: Accepted
   * Runtime: 30 ms
   */
  @Override
  public int swimInWater(int[][] grid) {
    final int N = grid.length;
    final boolean[] seen = new boolean[N * N];
    final Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return Integer.compare(grid[a / N][a % N], grid[b / N][b % N]);
      }
    });
    pq.add(0);

    int ans = 0;
    while (!pq.isEmpty()) {
      final int k = pq.remove(), row = k / N, col = k % N;
      ans = Math.max(ans, grid[row][col]);
      if (row == N - 1 && col == N - 1) {
        return ans;
      }
      for (final int[] dir : DIRS) {
        int newRow = row + dir[0], newCol = col + dir[1], newK = newRow * N + newCol;
        if (newRow >= 0 && newCol >= 0 && newRow < N && newCol < N && !seen[newK]) {
          pq.add(newK);
          seen[newK] = true;
        }
      }
    }

    throw new IllegalStateException();
  }
}
