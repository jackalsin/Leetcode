package _0751_0800._778_Swim_in_Rising_Water;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 3/6/2018.
 */
public final class BfsSolution implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  /**
   * Time Complexity O(N^2 Log(N))
   * 41 / 41 test cases passed.
   * Status: Accepted
   * Runtime: 34 ms
   */
  public int swimInWater(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length, T = rows * cols - 1;
    final boolean[][] visited = new boolean[rows][cols];
    final Queue<int[]> queue = new ArrayDeque<>();
    /* time to coordinate*/
    final TreeMap<Integer, int[]> blockedQueue = new TreeMap<>();
    blockedQueue.put(grid[0][0], new int[] {0, 0});
    for (int t = 0; t <= T; t++) {
      if (!blockedQueue.isEmpty() && blockedQueue.firstKey() <= t) {
        final Map.Entry<Integer, int[]> firstEntry = blockedQueue.firstEntry();
        blockedQueue.remove(firstEntry.getKey());
        queue.add(firstEntry.getValue());
      }

      while (!queue.isEmpty()) {
        final int[] coordinate = queue.remove();
        final int startRow = coordinate[0], startCol = coordinate[1];
        if (visited[startRow][startCol]) {
          continue;
        }
        visited[startRow][startCol] = true;
        if (startRow == rows - 1 && startCol == cols - 1) {
          return t;
        }
        for (final int[] dir : DIRS) {
          final int row = startRow + dir[0], col = startCol + dir[1];
          if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col]) {
            continue;
          }
          if (grid[row][col] >= t) {
            blockedQueue.put(grid[row][col], new int[] {row, col});
          } else {
            queue.add(new int[] {row, col});
          }
        }
      }
    }
    throw new IllegalStateException();
  }
}
