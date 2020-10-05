package _0801_0850._807_Max_Increase_to_Keep_City_Skyline;

public class Solution {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length;
    final int[] rowMax = new int[rows], colMax = new int[cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        rowMax[row] = Math.max(rowMax[row], grid[row][col]);
        colMax[col] = Math.max(colMax[col], grid[row][col]);
      }
    }
    int res = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        res += Math.min(rowMax[row], colMax[col]) - grid[row][col];
      }
    }
    return res;
  }
}
