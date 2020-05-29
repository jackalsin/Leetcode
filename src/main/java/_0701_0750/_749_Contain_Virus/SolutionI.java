package _0701_0750._749_Contain_Virus;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
public final class SolutionI implements Solution {
  private int R = 0, C = 0;
  private static final int INACTIVE = -1;

  /*
  grid:
    1 : infected
    0 : healthy
    -1: 被wall隔离了
  */
  public int containVirus(int[][] grid) {
    R = grid.length;
    C = grid[0].length;
    int res = 0;
    while (true) {
      final int wall = process(grid);
      if (wall == 0) break;
      res += wall;
    }
    return res;
  }

  private int process(final int[][] grid) {
    // we mark the next infect area as <c>color</c>
    int maxArea = 0, maxAreaWall = 0, maxRow = -1, maxCol = -1, color = 2;
    final int[][] visited = new int[R][C];
    for (int row = 0; row < R; ++row) {
      for (int col = 0; col < C; ++col) {
        if (grid[row][col] == 1 && visited[row][col] == 0) {
          final int[] walls = {0};
          final int area = getNextThreatenArea(grid, visited, color, row, col, walls);
          if (area > maxArea) {
            maxArea = area;
            maxRow = row;
            maxCol = col;
            maxAreaWall = walls[0];
          }
          color++;
        }
      }
    }    // end of row
    if (maxAreaWall == 0) {
      return maxAreaWall;
    }
    // mark the max virus area as inactive
    markInactive(grid, maxRow, maxCol);

    // virus march one more
    /*
    // cannot use the following code to update the color, one empty cell can be marked by difference infected
    // 1 0 1 -> the middle cell can be marked to different color and there is no guarantee.
    final Set<Integer> preservedColor = Set.of(1, INACTIVE, maxColor, 0);
    for (int i = 0; i < R; ++i) {
      for (int j = 0; j < C; ++j) {
        if (!preservedColor.contains(visited[i][j])) {
          grid[i][j] = 1;
        }
      }
    }
    */
    final boolean[][] visitSpread = new boolean[R][C];
    for (int i = 0; i < R; ++i) {
      for (int j = 0; j < C; ++j) {
        if (!visitSpread[i][j] && grid[i][j] == 1) {
          markSpread(grid, visitSpread, i, j);
        }
      }
    }
    return maxAreaWall;
  }

  /**
   * mark the infect
   */
  private void markSpread(final int[][] grid, final boolean[][] visit, int row, int col) {
    if (row < 0 || row >= R || col < 0 || col >= C || visit[row][col]) {
      return;
    }
    visit[row][col] = true;
    if (grid[row][col] == 1) {
      markSpread(grid, visit, row + 1, col);
      markSpread(grid, visit, row - 1, col);
      markSpread(grid, visit, row, col + 1);
      markSpread(grid, visit, row, col - 1);
    } else if (grid[row][col] == 0) {
      grid[row][col] = 1;
    }
    // we may hit grid[row][col] = -1
  }

  private void markInactive(final int[][] grid, final int row, final int col) {
    if (row < 0 || row >= R || col < 0 || col >= C || grid[row][col] != 1) return;
    grid[row][col] = INACTIVE;
    markInactive(grid, row + 1, col);
    markInactive(grid, row - 1, col);
    markInactive(grid, row, col + 1);
    markInactive(grid, row, col - 1);
  }

  /**
   * Get the area that will be infected next round
   */
  private int getNextThreatenArea(final int[][] grid, final int[][] visited, final int color,
                                  final int row, final int col, final int[] walls) {
    if (row < 0 || row >= R || col < 0 || col >= C) return 0;
    if (grid[row][col] == 0) {
      walls[0]++; // every time it from 1 to 0, wall can be increased
      if (visited[row][col] == color) return 0;
      visited[row][col] = color;
      return 1;
    }
    if (visited[row][col] == 1 || grid[row][col] == INACTIVE) return 0;
    visited[row][col] = 1;
    return getNextThreatenArea(grid, visited, color, row + 1, col, walls)
        + getNextThreatenArea(grid, visited, color, row - 1, col, walls)
        + getNextThreatenArea(grid, visited, color, row, col + 1, walls)
        + getNextThreatenArea(grid, visited, color, row, col - 1, walls);
  }
}
