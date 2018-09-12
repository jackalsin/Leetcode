package _651_700._695_Max_Area_of_Island;

public class Solution {
  int max = 0, count = 0;

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return max;
    }
    final int rows = grid.length, cols = grid[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1) {
          count = 0;
          dfs(grid, rows, cols, row, col);
          max = Math.max(count, max);
        }
      }
    }
    return max;
  }

  private void dfs(final int[][] grid, final int rows, final int cols, int row, int col) {
    if (row >= rows || row < 0 || col < 0 || col >= cols || grid[row][col] == 0) {
      return;
    }

    count++;
    grid[row][col] = 0;
    dfs(grid, rows, cols, row + 1, col);
    dfs(grid, rows, cols, row - 1, col);
    dfs(grid, rows, cols, row, col + 1);
    dfs(grid, rows, cols, row, col - 1);
  }

}
