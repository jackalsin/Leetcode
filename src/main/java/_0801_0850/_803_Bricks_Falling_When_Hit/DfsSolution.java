package _0801_0850._803_Bricks_Falling_When_Hit;

public final class DfsSolution implements Solution {
  private static final int EMPTY = 0, BRICK = 1, VISITED = 2;
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int[] hitBricks(int[][] grid, int[][] hits) {
    final int[] res = new int[hits.length];
    final int rows = grid.length, cols = grid[0].length;
    for (int i = 0; i < hits.length; i++) {
      final int[] hit = hits[i];
      // TODO: Finish the solution
//      System.out.println(Arrays.toString(hit));
      grid[hit[0]][hit[1]] = 0;
      final int cur = dfs(grid, rows, cols, hit[0], hit[1]);
      if (cur != -1) {
        res[i] = cur;
      }
    }
    return res;
  }

  /**
   * return -1 when found undroppable; otherwise, return the actual count;
   *
   * @param grid
   * @param rows
   * @param cols
   * @param row
   * @param col
   * @return
   */
  private static int dfs(final int[][] grid, final int rows, final int cols, int row, int col) {
    grid[row][col] = 0;
    int res = 0;
    for (final int[] d : DIRS) {
      final int cur = dfsHelper(grid, rows, cols, row + d[0], col + d[1]);
      if (cur != -1) {
        res += cur;
      }
    }
    return res;
  }

  private static int dfsHelper(final int[][] grid, final int rows, final int cols, int row, int col) {
    if (col < 0 || col >= cols || row >= rows || row < 0 || grid[row][col] == 0) {
      return 0;
    }
    if (row == 0) {
      return grid[row][col] == BRICK ? -1 : 0;
    }
    final int original = grid[row][col];
    grid[row][col] = 0;
    final int[] adjRes = {
        dfsHelper(grid, rows, cols, row + 1, col),
        dfsHelper(grid, rows, cols, row - 1, col),
        dfsHelper(grid, rows, cols, row, col + 1),
        dfsHelper(grid, rows, cols, row, col - 1)
    };
    if (adjRes[0] == -1 || adjRes[1] == -1 || adjRes[2] == -1 || adjRes[3] == -1) {
      grid[row][col] = original;
      return -1;
    }

    return 1 + adjRes[0] + adjRes[1] + adjRes[2] + adjRes[3];
  }
}
