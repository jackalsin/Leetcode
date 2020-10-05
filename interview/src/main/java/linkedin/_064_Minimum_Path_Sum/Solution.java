package linkedin._064_Minimum_Path_Sum;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public class Solution {

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    final int[][] dp = new int[rows][cols];
    dp[0][0] = grid[0][0];
    for (int col = 1; col < cols; ++col) {
      dp[0][col] = dp[0][col - 1] + grid[0][col];
    }

    for (int row = 1; row < rows; ++row) {
      dp[row][0] = dp[row - 1][0] + grid[row][0];
      for (int col = 1; col < cols; ++col) {
        dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
      }
    }
    return dp[rows - 1][cols - 1];
  }
}
