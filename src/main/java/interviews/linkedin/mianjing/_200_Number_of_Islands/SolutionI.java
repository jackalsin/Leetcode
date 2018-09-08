package interviews.linkedin.mianjing._200_Number_of_Islands;

import java.util.ArrayDeque;
import java.util.Queue;

public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    int res = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == '1') {
          res++;
          dfs(grid, row, col);
        }
      }
    }
    return res;
  }

  private void dfs(char[][] grid, int startRow, int startCol) {
    final Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{startRow, startCol});
    final int rows = grid.length, cols = grid[0].length;
    grid[startRow][startCol] = '0';
    while (!queue.isEmpty()) {
      final int[] toRemove = queue.remove();
      final int row = toRemove[0], col = toRemove[1];
      for (int[] dir : DIRS) {
        final int nextRow = row + dir[0], nextCol = col + dir[1];
        if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
          continue;
        }
        if (grid[nextRow][nextCol] == '0') {
          continue;
        }
        grid[nextRow][nextCol] = '0';
        queue.add(new int[]{nextRow, nextCol});
      }
    }
  }
}
