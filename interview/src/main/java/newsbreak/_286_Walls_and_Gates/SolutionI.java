package newsbreak._286_Walls_and_Gates;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
public final class SolutionI implements Solution {
  private static final int WALL = -1, EMPTY = Integer.MAX_VALUE, GATE = 0;
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
  };

  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0) {
      return;
    }
    final int rows = rooms.length, cols = rooms[0].length;
    final Queue<int[]> q = new ArrayDeque<>();
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (rooms[i][j] == GATE) {
          q.add(new int[]{i, j});
        }
      }
    } // end of for i

    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int x = toRemove[0], y = toRemove[1],
          nextDistance = rooms[x][y] + 1;
      for (final int[] d : DIRS) {
        final int nextX = d[0] + x, nextY = d[1] + y;
        if (0 <= nextX && nextX < rows && 0 <= nextY && nextY < cols && rooms[nextX][nextY] == EMPTY) {
          rooms[nextX][nextY] = nextDistance;
          q.add(new int[]{nextX, nextY});
        }
      }
    }
  }
}
