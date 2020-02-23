package _0801_0850._803_Bricks_Falling_When_Hit;

import utils.TwoDimensionArray;

/**
 * Time Complexity: O(N)
 */
public final class DfsSolution implements Solution {
  private static final int BRICK = 1;
  private static final int NOT_DROPPING_BRICK = 2;
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int[] hitBricks(int[][] grid, int[][] hits) {
    assert grid.length > 0 && grid[0].length > 0;
    final int rows = grid.length, cols = grid[0].length;

    for (final int[] h : hits) {
      grid[h[0]][h[1]]--;
    }

    for (int c = 0; c < cols; c++) {
      dfs(grid, rows, cols, 0, c);
    }


    final int[] res = new int[hits.length];
    for (int i = hits.length - 1; i >= 0; --i) {
      final int row = hits[i][0], col = hits[i][1];
      grid[row][col]++;
      if (grid[row][col] == BRICK && isConnectedToNotDroppingBrick(grid, rows, cols, row, col)) {
        res[i] = dfs(grid, rows, cols, row, col) - 1; // hit doesn't count
      }

      TwoDimensionArray.toString(grid);
    }
    return res;
  }

  private static boolean isConnectedToNotDroppingBrick(final int[][] grid, final int rows, final int cols,
                                                       int row, int col) {
    if (row == 0) {
      return true;
    }
    for (final int[] d : DIRS) {
      final int nextRow = row + d[0], nextCol = col + d[1];
      if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols && grid[nextRow][nextCol] == NOT_DROPPING_BRICK) {
        return true;
      }
    }
    return false;
  }

  private static int dfs(final int[][] grid, final int rows, final int cols, final int r, final int c) {

    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != BRICK) {
      return 0;
    }
    grid[r][c] = NOT_DROPPING_BRICK; // become not falling bricks
    return 1 + dfs(grid, rows, cols, r + 1, c)
        + dfs(grid, rows, cols, r - 1, c)
        + dfs(grid, rows, cols, r, c + 1)
        + dfs(grid, rows, cols, r, c - 1);
  }
}
