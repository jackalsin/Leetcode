package interviews.uber._695_Max_Area_of_Island;

public class Solution {
  private int rows, cols;

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    this.rows = grid.length;
    this.cols = grid[0].length;
    int maxArea = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          int area = dfs(grid, row, col);
          maxArea = Math.max(area, maxArea);
        }
      }
    }
    return maxArea;
  }

  private int dfs(int[][] grid, int row, int col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
      return 0;
    }
    grid[row][col] = 0;

    return 1 + dfs(grid, row + 1, col)
        + dfs(grid, row - 1, col)
        + dfs(grid, row, col + 1)
        + dfs(grid, row, col - 1);
  }
}
