package linkedin._695_Max_Area_of_Island;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionII implements Solution {
  private int max = 0;

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return max;
    }
    final int rows = grid.length, cols = grid[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 0) continue;
        max = Math.max(dfs(grid, row, col), max);
      }
    }
    return max;
  }

  private static int dfs(final int[][] grid, final int row, final int col) {
    final int rows = grid.length, cols = grid[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
      return 0;
    }
    grid[row][col] = 0;
    int res = 1;
    res += dfs(grid, row, col + 1);
    res += dfs(grid, row, col - 1);
    res += dfs(grid, row + 1, col);
    res += dfs(grid, row - 1, col);
    return res;
  }
}
