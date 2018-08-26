package dynamicProgramming._064_Minimum_Path_Sum;

public class Solution {

  public int minPathSum(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length;
    final int[][] path = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        path[row][col] = grid[row][col];
        if (row == 0 && col == 0) {
          continue;
        } else if (row == 0) {
          path[row][col] += path[row][col - 1];
        } else if (col == 0) {
          path[row][col] += path[row - 1][col];
        } else {
          path[row][col] += Math.min(path[row][col - 1], path[row - 1][col]);
        }
      }
    }
    return path[rows - 1][cols - 1];
  }
}
