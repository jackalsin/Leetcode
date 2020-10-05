package hulu._200_Number_of_Islands;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public final class SolutionI implements Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    int count = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == '1') {
          dfs(grid, rows, cols, row, col);
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs(final char[][] grid, final int rows, final int cols, final int row, final int col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
      return;
    }
    grid[row][col] = '0';
    dfs(grid, rows, cols, row + 1, col);
    dfs(grid, rows, cols, row - 1, col);
    dfs(grid, rows, cols, row, col + 1);
    dfs(grid, rows, cols, row, col - 1);
  }
}
