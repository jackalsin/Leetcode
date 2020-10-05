package byteDance._286_Walls_and_Gates;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {
  private static final int GATE = 0;
  private static final int INF = 2147483647;
  private final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
  };

  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0) {
      return;
    }
    final int rows = rooms.length, cols = rooms[0].length;
    final Queue<int[]> q = new ArrayDeque<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (rooms[row][col] == GATE) {
          q.add(new int[]{row, col});
        }
      }
    }
    int distance = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final int[] toRemove = q.remove();
        for (final int[] d : DIRS) {
          final int nextRow = toRemove[0] + d[0], nextCol = toRemove[1] + d[1];
          if (isInRange(rows, cols, nextRow, nextCol) && rooms[nextRow][nextCol] == INF) {
            rooms[nextRow][nextCol] = distance + 1;
            q.add(new int[]{nextRow, nextCol});
          }
        }
      }
      distance++;
    }
  }

  private boolean isInRange(int rows, int cols, int nextRow, int nextCol) {
    return 0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols;
  }
}
