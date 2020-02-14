package interviews.tableau._200_Number_of_Islands;

/**
 * @author jacka
 * @version 1.0 on 2/13/2020
 */
public final class SolutionI implements Solution {
  private static final char LAND = '1', WATER = '0';
  private int rows, cols;

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    rows = grid.length;
    cols = grid[0].length;
    int count = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == LAND) {
          dfs(grid, row, col);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(final char[][] grid, final int row, final int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == WATER) return;
    grid[row][col] = WATER;
    dfs(grid, row, col + 1);
    dfs(grid, row, col - 1);
    dfs(grid, row + 1, col);
    dfs(grid, row - 1, col);
  }
}
