package interviews.linkedin._695_Max_Area_of_Island;

/**
 * @author jacka
 * @version 1.0 on 9/13/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int max = 0;
    final int rows = grid.length, cols = grid[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1) {
          max = Math.max(max, maxAreaOfIsland(grid, rows, cols, row, col));
        }
      }
    }
    return max;
  }

  private static int maxAreaOfIsland(final int[][] grid, final int rows, final int cols,
                                     final int row, final int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
      return 0;
    }
    int res = 1;
    grid[row][col] = 0;
    res += maxAreaOfIsland(grid, rows, cols, row + 1, col)
        + maxAreaOfIsland(grid, rows, cols, row - 1, col)
        + maxAreaOfIsland(grid, rows, cols, row, col + 1)
        + maxAreaOfIsland(grid, rows, cols, row, col - 1);
    return res;
  }
}
