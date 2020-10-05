package byteDance._695_Max_Area_of_Island;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  private static final int ISLAND = 1, WATER = 0;

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int max = 0;
    final int rows = grid.length, cols = grid[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        int cur = dfs(grid, rows, cols, row, col);
        max = Math.max(cur, max);
      }
    }
    return max;
  }

  private static int dfs(final int[][] grid, final int rows, final int cols, final int row, final int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == WATER) {
      return 0;
    }
    grid[row][col] = WATER;
    int cur = 1;
    cur += dfs(grid, rows, cols, row + 1, col);
    cur += dfs(grid, rows, cols, row - 1, col);
    cur += dfs(grid, rows, cols, row, col + 1);
    cur += dfs(grid, rows, cols, row, col - 1);
    return cur;
  }
}
