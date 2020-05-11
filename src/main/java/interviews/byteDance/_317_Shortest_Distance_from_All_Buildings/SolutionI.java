package interviews.byteDance._317_Shortest_Distance_from_All_Buildings;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int shortestDistance(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int totalBuildings = 0;
    final int rows = grid.length, cols = grid[0].length;
    final int[][] distances = new int[rows][cols],
        reachedBuildings = new int[rows][cols];
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1) {
          totalBuildings++;
          final Queue<int[]> q = new ArrayDeque<>();
          q.add(new int[]{row, col});
          final boolean[][] visited = new boolean[rows][cols];
          visited[row][col] = true;
          int level = 0;
          while (!q.isEmpty()) {
            final int size = q.size();
            level++;
            for (int i = 0; i < size; ++i) {
              final int[] toRemove = q.remove();
              for (final int[] d : DIRS) {
                final int nextRow = d[0] + toRemove[0],
                    nextCol = d[1] + toRemove[1];
                if (!isValid(grid, visited, rows, cols, nextRow, nextCol)) {
                  continue;
                }
                visited[nextRow][nextCol] = true;
                reachedBuildings[nextRow][nextCol]++;
                distances[nextRow][nextCol] += level;
                q.add(new int[]{nextRow, nextCol});
              }
            } // end of for size loop
          }
        }

      }
    }
    int minDistance = Integer.MAX_VALUE;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (reachedBuildings[row][col] == totalBuildings && minDistance > distances[row][col]) {
          minDistance = distances[row][col];
        }
      }
    }
    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }

  private static boolean isValid(final int[][] grid, boolean[][] visited, final int rows, final int cols,
                                 final int row, final int col) {
    return row >= 0 && col >= 0 && row < rows && col < cols && !visited[row][col] && grid[row][col] == 0;
  }
}
