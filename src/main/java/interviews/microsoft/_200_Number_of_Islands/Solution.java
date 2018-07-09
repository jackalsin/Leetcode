package interviews.microsoft._200_Number_of_Islands;

public class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    int count = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] != '0') {
          count++;
          dfs(grid, row, col);
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int row, int col) {
    final int rows = grid.length, cols = grid[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
      return;
    }
    grid[row][col] = '0';
    dfs(grid, row + 1, col);
    dfs(grid, row - 1, col);
    dfs(grid, row, col + 1);
    dfs(grid, row, col - 1);

  }
}
