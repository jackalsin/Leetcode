package apple._200_Number_of_Islands;

/**
 * @author jacka
 * @version 1.0 on 2/22/2021
 */
public final class SolutionI implements Solution {
  private static final char LAND = '1', EMPTY = '0';
  private int rows = 0, cols = 0;

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    rows = grid.length;
    cols = grid[0].length;
    int result = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (grid[i][j] == LAND) {
          dfs(grid, i, j);
          result++;
        }
      }
    }
    return result;
  }

  private void dfs(final char[][] grid, final int row, int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != LAND) {
      return;
    }
    grid[row][col] = EMPTY;
    dfs(grid, row + 1, col);
    dfs(grid, row - 1, col);
    dfs(grid, row, col + 1);
    dfs(grid, row, col - 1);
  }
}
