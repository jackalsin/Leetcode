package google.mazeTravelLess.canReach;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/7/2021
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
  };

  public boolean canReach(int[][] maze) {
    if (maze == null || maze[0] == null) return true;
    final int rows = maze.length, cols = maze[0].length;
    if (rows == 1 && cols == 1) return true;
    final Queue<int[]> q = new ArrayDeque<>() {{
      add(new int[]{0, 0});
    }};
    maze[0][0] = -Math.abs(maze[0][0]);
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int row = toRemove[0], col = toRemove[1];
      for (final int[] d : DIRS) {
        final int nextRow = d[0] + row, nextCol = d[1] + col;
        if (!isInRange(nextRow, nextCol, rows, cols) || maze[nextRow][nextCol] < 0 ||
            Math.abs(maze[nextRow][nextCol]) > Math.abs(maze[row][col])) continue;
        if (nextRow == rows - 1 && nextCol == cols - 1) return true;
        maze[nextRow][nextCol] = -Math.abs(maze[nextRow][nextCol]);
        q.add(new int[]{nextRow, nextCol});
      }
    }
    return false;
  }

  private static boolean isInRange(final int row, final int col, final int rows, final int cols) {
    return 0 <= row && col >= 0 && row < rows && col < cols;
  }
}
