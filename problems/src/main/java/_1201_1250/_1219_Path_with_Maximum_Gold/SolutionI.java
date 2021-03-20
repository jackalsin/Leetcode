package _1201_1250._1219_Path_with_Maximum_Gold;

/**
 * @author jacka
 * @version 1.0 on 3/19/2021
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
  };
  private static final int VISITED = 0;
  private int rows, cols;

  @Override
  public int getMaximumGold(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    rows = grid.length;
    cols = grid[0].length;
    int max = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        max = Math.max(max, getMaximumGold(grid, row, col));
      }
    }
    return max;
  }

  private int getMaximumGold(final int[][] grid, final int row, final int col) {
    if (!isInRange(row, col) || grid[row][col] == VISITED) {
      return 0;
    }
    int maxResult = 0, oldVal = grid[row][col];
    grid[row][col] = VISITED;
    for (final int[] dir : DIRS) {
      final int nextRow = row + dir[0], nextCol = col + dir[1];
      maxResult = Math.max(maxResult, oldVal + getMaximumGold(grid, nextRow, nextCol));
    }
    grid[row][col] = oldVal;
    return maxResult;
  }

  private boolean isInRange(final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

}
