package linkedin._200_Number_of_Islands;

/**
 * @author jacka
 * @version 1.0 on 7/7/2019
 */
public final class SolutionII implements Solution {
  private static final char WATER = '0', LAND = '1';

  @Override
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int count = 0;
    final int rows = grid.length, cols = grid[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == LAND) {
          dfs(grid, rows, cols, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(final char[][] grid, final int rows, final int cols, final int row, final int col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == WATER) {
      return;
    }
    grid[row][col] = WATER;
    dfs(grid, rows, cols, row + 1, col);
    dfs(grid, rows, cols, row - 1, col);
    dfs(grid, rows, cols, row, col + 1);
    dfs(grid, rows, cols, row, col - 1);
  }
}
