package _051_100._063_Unique_Paths_II;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/24/2017.
 */
public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    if (m == 0) return 0;
    int n = obstacleGrid[0].length;
    if (n == 0) return 0;
    int[][] paths = new int[m][n];
    for(int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (obstacleGrid[row][col] == 1) {
          paths[row][col] = 0;
        } else if (row == 0) {
          if (col == 0) {
            paths[row][col] = 1;
          } else {
            paths[row][col] = paths[row][col - 1];
          }
        } else if (col == 0) {
          paths[row][col] = paths[row - 1][col];
        } else {
          paths[row][col] = paths[row][col - 1] + paths[row - 1][col];
        }
      }
    }
    return paths[m - 1][n - 1];
  }
}
