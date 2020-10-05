package _0651_0700._695_Max_Area_of_Island;

public class Solution {
  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    int max = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          max = Math.max(max, dfs(grid, rows, cols, row, col));
        }
      }

    }
    return max;
  }

  private static int dfs(final int[][] grid, final int rows, final int cols, final int row, final int col) {
    if (row < 0 || col < 0 || col >= cols || row >= rows || grid[row][col] == 0)
      return 0;
    grid[row][col] = 0;
    return 1 + dfs(grid, rows, cols, row + 1, col) +
        dfs(grid, rows, cols, row - 1, col) +
        dfs(grid, rows, cols, row, col + 1) +
        dfs(grid, rows, cols, row, col - 1);
  }

}
