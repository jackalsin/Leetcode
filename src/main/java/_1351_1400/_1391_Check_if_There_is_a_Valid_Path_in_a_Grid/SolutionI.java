package _1351_1400._1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
public class SolutionI implements Solution {
  private static final int[][][] DIRS = {
      {{0, -1}, {0, 1}},
      {{-1, 0}, {1, 0}},
      {{0, -1}, {1, 0}},
      {{0, 1}, {1, 0}},
      {{0, -1}, {-1, 0}},
      {{0, 1}, {-1, 0}}
  };

  public boolean hasValidPath(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return true;
    }
    final int rows = grid.length, cols = grid[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    final Queue<int[]> q = new ArrayDeque<>();
    visited[0][0] = true;
    q.add(new int[]{0, 0});
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int row = toRemove[0], col = toRemove[1];
      final int[][] dirs = DIRS[grid[row][col] - 1];
      for (final int[] d : dirs) {
        final int nextRow = row + d[0], nextCol = col + d[1];
        if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
          continue;
        }
        // go next cell and come back to see if it's connected
        for (final int[] nextD : DIRS[grid[nextRow][nextCol] - 1]) {
          final int srcRow = nextRow + nextD[0], srcCol = nextCol + nextD[1];
          if (srcRow == row && srcCol == col) {
            q.add(new int[]{nextRow, nextCol});
            visited[nextRow][nextCol] = true;
          }
        }
      }
    }
    return visited[rows - 1][cols - 1];
  }
}
