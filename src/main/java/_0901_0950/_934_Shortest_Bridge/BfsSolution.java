package _0901_0950._934_Shortest_Bridge;

import java.util.ArrayDeque;
import java.util.Queue;

public final class BfsSolution implements Solution {

  private static final int[][] DIRS = {
      {0, 1}, {0, -1},
      {1, 0}, {-1, 0}
  };

  public int shortestBridge(int[][] grid) {
    assert 1 <= grid.length && grid.length <= 100 && 1 <= grid[0].length && grid[0].length <= 100;
    final int rows = grid.length, cols = grid[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    final Queue<int[]> q = new ArrayDeque<>();
    out:
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          dfs(grid, rows, cols, q, visited, row, col);
          break out;
        }
      }
    }


    int distance = 0; // 如果预先碰到终结，则distance刚好
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final int[] p = q.remove();
        for (final int[] d : DIRS) {
          final int nextRow = p[0] + d[0], nextCol = p[1] + d[1];
          if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols
              || visited[nextRow][nextCol]) {
            continue;
          }
          if (grid[nextRow][nextCol] == 1) {
            return distance;
          }
          visited[nextRow][nextCol] = true;
          q.add(new int[]{nextRow, nextCol});
        }
      }
      distance++;
    }
    return distance;
  }

  private static void dfs(final int[][] grid, final int rows, final int cols, Queue<int[]> q, boolean[][] visited, final int row, final int col) {
    if (!isValid(rows, cols, row, col) || grid[row][col] == 0 || visited[row][col]) {
      return;
    }
    visited[row][col] = true;
    q.add(new int[]{row, col});
    dfs(grid, rows, cols, q, visited, row + 1, col);
    dfs(grid, rows, cols, q, visited, row - 1, col);
    dfs(grid, rows, cols, q, visited, row, col + 1);
    dfs(grid, rows, cols, q, visited, row, col - 1);
  }

  private static boolean isValid(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

}
