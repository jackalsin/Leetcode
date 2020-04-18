package _0051_0100._064_Minimum_Path_Sum;

/**
 * @author jacka
 * @version 1.0 on 4/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    for (int j = 1; j < cols; ++j) {
      grid[0][j] += grid[0][j - 1];
    }
    for (int i = 1; i < rows; ++i) {
      grid[i][0] += grid[i - 1][0];
      for (int j = 1; j < cols; ++j) {
        grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
      }
    }
    return grid[rows - 1][cols - 1];
  }
}
