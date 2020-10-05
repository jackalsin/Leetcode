package linkedin.mianjing._200_Number_of_Islands;

import java.util.ArrayDeque;
import java.util.Queue;

public final class SolutionII implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int count = 0;
    final int rows = grid.length, cols = grid[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == '1') {
          dfs(grid, rows, cols, row, col);
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs(final char[][] grid, final int rows, final int cols, int startRow, int startCol) {
    final Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{startRow, startCol});
    grid[startRow][startCol] = '0';
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int row = toRemove[0], col = toRemove[1];
      for (final int[] dir : DIRS) {
        final int nextRow = row + dir[0], nextCol = col + dir[1];
        if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == '1') {
          q.add(new int[]{nextRow, nextCol});
          grid[nextRow][nextCol] = '0';
        }
      }
    }
  }

}
