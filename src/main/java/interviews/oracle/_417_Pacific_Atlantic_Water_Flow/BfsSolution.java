package interviews.oracle._417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 11/29/2019
 */
public final class BfsSolution implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {-1, 0}, {0, -1}
  };

  @Override
  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    final List<List<Integer>> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final boolean[][] pacific = new boolean[rows][cols], atlantic = new boolean[rows][cols];
    final Queue<int[]> pQueue = new ArrayDeque<>(), aQueue = new ArrayDeque<>();
    for (int col = 0; col < cols; ++col) {
      pQueue.add(new int[]{0, col});
      pacific[0][col] = true;
      aQueue.add(new int[]{rows - 1, col});
      atlantic[rows - 1][col] = true;
    }
    for (int row = 0; row < rows; ++row) {
      pQueue.add(new int[]{row, 0});
      pacific[row][0] = true;
      aQueue.add(new int[]{row, cols - 1});
      atlantic[row][cols - 1] = true;
    }
    bfs(matrix, pQueue, pacific);
    bfs(matrix, aQueue, atlantic);
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (pacific[row][col] && atlantic[row][col]) {
          result.add(Arrays.asList(row, col));
        }
      }
    }
    return result;
  }

  private static void bfs(final int[][] matrix, final Queue<int[]> q, final boolean[][] visited) {
    final int rows = matrix.length, cols = matrix[0].length;
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int row = toRemove[0], col = toRemove[1];
      for (final int[] dir : DIRS) {
        final int nextRow = toRemove[0] + dir[0], nextCol = toRemove[1] + dir[1];
        if (isValid(rows, cols, nextRow, nextCol) && !visited[nextRow][nextCol] && matrix[nextRow][nextCol] >= matrix[row][col]) {
          visited[nextRow][nextCol] = true;
          q.add(new int[]{nextRow, nextCol});
        }
      }
    }
  }

  private static boolean isValid(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}
