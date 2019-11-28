package _1051_1100._1091_Shortest_Path_in_Binary_Matrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 11/28/2019
 */
public final class BfsSolution implements Solution {
  private static final int[][] DIRS = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, {0, 1},
      {1, -1}, {1, 0}, {1, 1}
  };

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    if (grid[0][0] == 1) {
      return -1;
    }
    final int rows = grid.length, cols = grid[0].length;
    final Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{0, 0, 1});
    while (!q.isEmpty()) {
      final int[] p = q.remove();
      final int row = p[0], col = p[1], dist = p[2];
      if (row == rows - 1 && col == cols - 1) {
        return dist;
      }
      for (final int[] dir : DIRS) {
        final int nextRow = dir[0] + row, nextCol = dir[1] + col,
            nextDist = dist + 1;
        if (isValid(grid, nextRow, nextCol)) {

          grid[nextRow][nextCol] = 1;
          q.add(new int[]{nextRow, nextCol, nextDist});
        }
      }
    }
    return -1;
  }

  private static boolean isValid(final int[][] grid, final int row, final int col) {
    final int rows = grid.length, cols = grid[0].length;
    return 0 <= row && row < rows && 0 <= col && col < cols && grid[row][col] == 0;
  }
}
