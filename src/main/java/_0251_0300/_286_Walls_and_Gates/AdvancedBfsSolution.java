package _0251_0300._286_Walls_and_Gates;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/5/2017.
 */
public class AdvancedBfsSolution implements Solution {
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private static final int INF = Integer.MAX_VALUE;

  @Override
  public void wallsAndGates(int[][] rooms) {
    int rows = rooms.length;
    if (rows == 0) return;
    int cols = rooms[0].length;
    if (cols == 0) return;
    Queue<int[]> toVisit = new ArrayDeque<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (rooms[row][col] == 0) {
          toVisit.add(new int[] {row, col});
        }
      }
    }
    bfs(rooms, toVisit, rows, cols);
  }

  private void bfs(final int[][] rooms, final Queue<int[]> toVisit,
                   final int rows, final int cols) {
    int depth = 1;
    while (!toVisit.isEmpty()) {
      int size = toVisit.size();
      for (int i = 0; i < size; ++i) {
        int[] coordinate = toVisit.remove();
        final int row = coordinate[0], col = coordinate[1];
        for (int[] dir : DIRS) {
          if (isValidToVisit(rooms, rows, cols, row + dir[0], col + dir[1])) {
            rooms[row + dir[0]][col + dir[1]] = depth;
            toVisit.add(new int[]{row + dir[0], col + dir[1]});
          }
        }
      } // end of for loop of size
      depth++;
    }
  }

  private boolean isValidToVisit(final int[][] rooms, final int rows, final int cols,
                                 int row, int col) {
    return row >= 0 && row < rows && col < cols && col >= 0 && rooms[row][col] == INF;

  }
}
