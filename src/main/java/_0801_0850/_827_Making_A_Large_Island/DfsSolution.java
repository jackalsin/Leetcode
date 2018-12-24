package _0801_0850._827_Making_A_Large_Island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DfsSolution implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  /**
   * Time Complexity: O(N^2)
   */
  public int largestIsland(int[][] grid) {
    final int N = grid.length;
    final Map<Integer, Integer> idToArea = new HashMap<>();
    int id = 1;
    for (int row = 0; row < N; row++) {
      for (int col = 0; col < N; col++) {
        if (grid[row][col] == 1) {
          id++;
          int area = dfs(grid, N, row, col, id);
          idToArea.put(id, area);
        }
      }
    }
    int maxArea = 0;
    for (int row = 0; row < N; row++) {
      for (int col = 0; col < N; col++) {
        if (grid[row][col] == 0) {
          final Set<Integer> neighbors = new HashSet<>();
          for (final int[] d : DIRS) {
            final int nextRow = row + d[0], nextCol = col + d[1];
            if (isInRange(nextRow, nextCol, N) && grid[nextRow][nextCol] > 1) {
              neighbors.add(grid[nextRow][nextCol]);
            }
          } // end of DIRS
          int area = 1;
          for (int i : neighbors) {
            area += idToArea.get(i);
          }
          maxArea = Math.max(maxArea, area);
        } else if (grid[row][col] > 1) {
          maxArea = Math.max(maxArea, idToArea.get(grid[row][col]));
        }
      }
    }

    return maxArea;
  }

  private static int dfs(final int[][] grid, final int N, final int row, final int col, final int id) {
    if (!isInRange(row, col, N) || (grid[row][col] <= id && grid[row][col] != 1)) {
      return 0;
    }
    grid[row][col] = id;

    return 1 + dfs(grid, N, row - 1, col, id)
        + dfs(grid, N, row + 1, col, id)
        + dfs(grid, N, row, col - 1, id)
        + dfs(grid, N, row, col + 1, id);
  }

  private static boolean isInRange(final int row, final int col, final int N) {
    return row >= 0 && row < N && col >= 0 && col < N;
  }
}
