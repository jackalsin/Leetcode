package interviews.facebook._200_Number_of_Islands;

public class Solution {
  public int numIslands(char[][] grid) {
    int count = 0;
    if (grid == null || grid.length == 0) {
      return count;
    }
    final int rows = grid.length, cols = grid[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == '1') {
          dfs(grid, rows, cols, row, col);
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs(final char[][] grid, final int rows, final int cols,
                          final int startRow, final int startCol) {
    if (startRow >= rows || startRow < 0 || startCol >= cols || startCol < 0 || grid[startRow][startCol] == '0') {
      return;
    }
    grid[startRow][startCol] = '0';
    dfs(grid, rows, cols, startRow + 1, startCol);
    dfs(grid, rows, cols, startRow - 1, startCol);
    dfs(grid, rows, cols, startRow, startCol + 1);
    dfs(grid, rows, cols, startRow, startCol - 1);
  }
}
