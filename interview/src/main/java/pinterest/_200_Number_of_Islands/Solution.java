package pinterest._200_Number_of_Islands;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  private static final char ISLAND = '1';
  private static final int[][] DIRS = {
      {-1, 0}, {1, 0}, {0, 1}, {0, -1}
  };

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    int island = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == ISLAND && !visited[row][col]) {
          island++;
          bfs(grid, visited, row, col);
        }
      }
    }
    return island;
  }

  private void bfs(final char[][] grid, final boolean[][] visited, final int startRow, final int startCol) {
    final Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{startRow, startCol});
    visited[startRow][startCol] = true;
    while (!queue.isEmpty()) {
      final int[] cell = queue.remove();
      for (int[] dir : DIRS) {
        int nextRow = dir[0] + cell[0];
        int nextCol = dir[1] + cell[1];
        if (isValid(grid, visited, nextRow, nextCol)) {
          visited[nextRow][nextCol] = true;
          queue.add(new int[]{nextRow, nextCol});
        }
      }
    }
  }

  private boolean isValid(char[][] grid, boolean[][] visited, int row, int col) {
    final int rows = grid.length, cols = grid[0].length;
    return 0 <= row && row < rows && 0 <= col && col < cols && grid[row][col] == ISLAND && !visited[row][col];
  }
}