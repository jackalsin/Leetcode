package _1601_1650._1631_Path_With_Minimum_Effort;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minimumEffortPath(int[][] heights) {
    int left = 0, right = (int) 1E6;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (canReach(heights, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  private boolean canReach(final int[][] heights, final int mid) {
    final int rows = heights.length, cols = heights[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    return dfs(heights, visited, 0, 0, mid);
  }

  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {-1, 0}, {0, -1}
  };

  private boolean dfs(final int[][] heights, final boolean[][] visited, final int row,
                      final int col, final int maxHeight) {
    final int rows = heights.length, cols = heights[0].length;
    if (row == rows - 1 && col == cols - 1) {
      return true;
    }
    visited[row][col] = true;
    for (final int[] d : DIRS) {
      final int nextRow = d[0] + row, nextCol = d[1] + col;
      if (nextRow < 0 || nextCol < 0 || nextCol >= cols || nextRow >= rows ||
          visited[nextRow][nextCol]) {
        continue;
      }
      if (Math.abs(heights[nextRow][nextCol] - heights[row][col]) > maxHeight) continue;
      if (dfs(heights, visited, nextRow, nextCol, maxHeight)) {
        return true;
      }
    }
    return false;
  }
}
