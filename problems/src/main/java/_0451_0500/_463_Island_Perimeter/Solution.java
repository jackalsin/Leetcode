package _0451_0500._463_Island_Perimeter;

public class Solution {
  public int islandPerimeter(int[][] grid) {
    int count = 0;
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          count += 4;
          if (row != 0 && grid[row - 1][col] == 1) {
            count -= 2;
          }
          if (col != 0 && grid[row][col - 1] == 1) {
            count -= 2;
          }
        }
      }
    }
    return count;
  }
}
