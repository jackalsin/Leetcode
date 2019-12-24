package _0951_1000._994_Rotting_Oranges;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 12/23/2019
 */
public final class SolutionI implements Solution {
  //  the value 0 representing an empty cell;
//  the value 1 representing a fresh orange;
//  the value 2 representing a rotten orange.
  private static final int EMPTY = 0,
      FRESH = 1, ROTTEN = 2;
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final Queue<int[]> q = new ArrayDeque<>();
    int freshes = 0;
    final int rows = grid.length, cols = grid[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == ROTTEN) {
          q.add(new int[]{row, col});
        } else if (grid[row][col] == FRESH) {
          freshes++;
        }
      }
    }
    if (freshes == 0) {
      return 0;
    }
    int steps = -1;
    while (!q.isEmpty()) {
      final int size = q.size();
      steps++;
      for (int i = 0; i < size; ++i) {
        final int[] toRemove = q.remove();
        final int row = toRemove[0], col = toRemove[1];
        for (final int[] dir : DIRS) {
          final int nextRow = row + dir[0], nextCol = col + dir[1];
          if (!isValid(rows, cols, nextRow, nextCol)) continue;
          if (grid[nextRow][nextCol] != FRESH) continue;
          grid[nextRow][nextCol] = ROTTEN;
          freshes--;
          q.add(new int[]{nextRow, nextCol});
        }
      }
    }

    return freshes == 0 ? steps : -1;
  }

  private static boolean isValid(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

}
