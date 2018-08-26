package dynamicProgramming._063_Unique_Paths_II;

public class Solution {
  public int uniquePathsWithObstacles(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length;
    final int[][] path = new int[rows][cols];
    path[0][0] = grid[0][0] == 1 ? 0 : 1;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) continue;
        if (i > 0) {
          path[i][j] += path[i - 1][j];
        }
        if (j > 0) {
          path[i][j] += path[i][j - 1];
        }
      }
    }
    return path[rows - 1][cols - 1];
  }
}
