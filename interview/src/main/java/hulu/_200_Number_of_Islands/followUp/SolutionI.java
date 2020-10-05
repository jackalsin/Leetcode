package hulu._200_Number_of_Islands.followUp;

/**
 * @author jacka
 * @version 1.0 on 2/4/2020
 */
public final class SolutionI implements Solution {
  private static final char LAND = '1',
      WATER = '0';

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    int res = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == LAND) {
          dfs(grid, rows, cols, row, col);
          res++;
        }
      }
    }
    return res;
  }

  private static void dfs(final char[][] grid, int rows, int cols, int row, int col) {
    row = (row + rows) % rows;
    col = (col + cols) % cols;

    if (grid[row][col] == WATER) {
      return;
    }
    grid[row][col] = WATER;
    dfs(grid, rows, cols, row + 1, col);
    dfs(grid, rows, cols, row - 1, col);
    dfs(grid, rows, cols, row, col + 1);
    dfs(grid, rows, cols, row, col - 1);
  }
}
