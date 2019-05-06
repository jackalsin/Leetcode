package _1001_1050._1034_Coloring_A_Border;

import java.util.HashSet;
import java.util.Set;

public final class DfsSolution implements Solution {
  private int rows, cols;
  private final Set<Long> visited = new HashSet<>();

  public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
    if (grid == null || grid.length == 0) {
      return grid;
    }
    rows = grid.length;
    cols = grid[0].length;
    dfs(grid, new HashSet<>(), r0, c0, grid[r0][c0], color);
    return grid;
  }

  /**
   * @param grid
   * @param visited
   * @param row
   * @param col
   * @param original
   * @param color
   * @return true if the current position already goes over the border
   */
  private boolean dfs(final int[][] grid, final Set<Long> visited, final int row, final int col, final int original, final int color) {
    final long pos = getPos(row, col);
    if (visited.contains(pos)) return false;
    if (!isInRange(row, col) || grid[row][col] != original) {
      return true;
    }
    visited.add(pos);
    final boolean left = dfs(grid, visited, row, col - 1, original, color),
        right = dfs(grid, visited, row, col + 1, original, color),
        top = dfs(grid, visited, row - 1, col, original, color),
        bottom = dfs(grid, visited, row + 1, col, original, color);

    if (left | right | top | bottom) {
      grid[row][col] = color;
    }
    return false;
  }

  private static long getPos(final int row, final int col) {
    return (((long) row) << 32) | col;
  }

  private boolean isInRange(final int row, final int col) {
    return 0 <= row && row < rows & 0 <= col && col < cols;
  }
}
