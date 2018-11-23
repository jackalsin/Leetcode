package _0251_0300._286_Walls_and_Gates;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This solution is doing bfs every time when the room[row][col] is door.
 * The time complexity is O(N^4)
 *
 *
 * @author jacka
 * @version 1.0 on 9/5/2017.
 */
public class NaiveBfsSolution implements Solution {

  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  @Override
  public void wallsAndGates(int[][] rooms) {
    int rows = rooms.length;
    if (rows == 0) return;
    int cols = rooms[0].length;
    if (cols == 0) return;

    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (rooms[row][col] == 0) {
          final boolean[][] visited = new boolean[rows][cols];
          visited[row][col] = true;
          bfs(rooms, visited, rows, cols, row, col);
        }
      }
    }
  }

  private void bfs(final int[][] rooms, final boolean[][] visited,
                   final int rows, final int cols, int startRow, int startCol) {
    Deque<int[]> deque = new ArrayDeque<>(); // don't use equals
    for(int[] dir : DIRS) {
      if (isValidToVisit(rooms, visited, rows, cols, startRow + dir[0], startCol + dir[1])) {
        deque.add(new int[]{startRow + dir[0], startCol + dir[1]});
      }
    }
    int depth = 1;
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; ++i) {
        int[] coordinate = deque.remove();
        final int row = coordinate[0], col = coordinate[1];
        rooms[row][col] = Math.min(rooms[row][col], depth);
        visited[row][col] = true;
        for (int[] dir : DIRS) {
          if (isValidToVisit(rooms, visited, rows, cols, row + dir[0], col + dir[1])) {
            deque.add(new int[]{row + dir[0], col + dir[1]});
          }
        }
      } // end of for loop of size
      depth++;
    }
  }

  private boolean isValidToVisit(final int[][] rooms, final boolean[][] visited,
                                 final int rows, final int cols, int row, int col) {
    return row >= 0 && row < rows && col < cols && col >= 0
        && rooms[row][col] != 0 && rooms[row][col] != -1 && !visited[row][col];
  }
}
