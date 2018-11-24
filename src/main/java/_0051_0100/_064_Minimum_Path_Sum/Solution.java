package _0051_0100._064_Minimum_Path_Sum;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/24/2017.
 */
public class Solution {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    if (m == 0) return 0;
    int n = grid[0].length;
    if (n == 0) return 0;
    int[][] minSum = new int[m][n];
    minSum[0][0] = grid[0][0];
    for (int col = 1; col < n; col++) {
      minSum[0][col] = minSum[0][col - 1] + grid[0][col];
    }
    for (int row = 1; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (col == 0) {
          minSum[row][col] = minSum[row - 1][col] + grid[row][col];
        } else {
          minSum[row][col] = Math.min(minSum[row - 1][col], minSum[row][col - 1]) + grid[row][col];
        }
      }
    }
    return minSum[m - 1][n - 1];
  }

}
