package google._695_Max_Area_of_Island;

/**
 * @author jacka
 * @version 1.0 on 5/9/2021
 */
public final class SolutionI implements Solution {
  private static final int VISITED = 2, L = 1, W = 0;

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    final int rows = grid.length, cols = grid[0].length;
    int max = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        final int cur = dfs(grid, rows, cols, i, j);
        max = Math.max(cur, max);
      }
    }
    return max;
  }

  private int dfs(final int[][] grid, final int rows, final int cols, final int i, final int j) {
    if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == VISITED || grid[i][j] == W) return 0;
    grid[i][j] = VISITED;
    return 1
        + dfs(grid, rows, cols, i + 1, j)
        + dfs(grid, rows, cols, i - 1, j)
        + dfs(grid, rows, cols, i, j + 1)
        + dfs(grid, rows, cols, i, j - 1);
  }
}
