package interviews.linkedin._695_Max_Area_of_Island;

public class SolutionI implements Solution {
  @Override
  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    int maxArea = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1) {
          final int curArea = dfs(grid, rows, cols, row, col);
          if (curArea > maxArea) {
            maxArea = curArea;
          }
        }
      }
    }
    return maxArea;
  }

  private static int dfs(final int[][] grid, final int rows, final int cols, final int startRow,
                         final int startCol) {
    if (startRow >= rows || startRow < 0 || startCol < 0 || startCol >= cols || grid[startRow][startCol] != 1) {
      return 0;
    }
    int sum = 1;
    grid[startRow][startCol] = 0;
    sum += dfs(grid, rows, cols, startRow + 1, startCol)
        + dfs(grid, rows, cols, startRow, startCol + 1)
        + dfs(grid, rows, cols, startRow - 1, startCol)
        + dfs(grid, rows, cols, startRow, startCol - 1);
    return sum;
  }
}
