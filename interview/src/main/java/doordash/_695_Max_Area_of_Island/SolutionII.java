package doordash._695_Max_Area_of_Island;

/**
 * @author jacka
 * @version 1.0 on 7/10/2021
 */
public final class SolutionII implements Solution {
  private static final int LAND = 1, EMPTY = 0;

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    final int rows = grid.length, cols = grid[0].length;
    int max = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        final int cur = dfs(grid, rows, cols, row, col);
        max = Math.max(max, cur);
      }
    }
    return max;
  }

  private static int dfs(final int[][] grid, final int rows, final int cols, final int row, final int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == EMPTY) return 0;
    grid[row][col] = EMPTY;
    return 1
        + dfs(grid, rows, cols, row - 1, col)
        + dfs(grid, rows, cols, row + 1, col)
        + dfs(grid, rows, cols, row, col + 1)
        + dfs(grid, rows, cols, row, col - 1);
  }
}
