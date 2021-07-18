package doordash._695_Max_Area_of_Island;

/**
 * @author jacka
 * @version 1.0 on 7/10/2021
 */
public final class SolutionII implements Solution {
  private static final int LAND = 1, EMPTY = 0;

  public int maxAreaOfIsland(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length;
    int max = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        final int curArea = dfs(grid, rows, cols, i, j);
        max = Math.max(curArea, max);
      }
    }
    return max;
  }

  private static int dfs(final int[][] grid, final int rows, final int cols, final int i, final int j) {
    if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == EMPTY) return 0;
    grid[i][j] = EMPTY;
    return 1 + dfs(grid, rows, cols, i + 1, j)
        + dfs(grid, rows, cols, i - 1, j)
        + dfs(grid, rows, cols, i, j + 1)
        + dfs(grid, rows, cols, i, j - 1);
  }
}
