package _451_500._490_The_Maze;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 12/3/2017.
 */
public class BFSSolution implements Solution {
  private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  /**
   * 78 / 78 test cases passed.
   * Status: Accepted
   * Runtime: 20 ms
   */
  @Override
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze.length == 0 || maze[0].length == 0) {
      return false;
    }
    final int rows = maze.length, cols = maze[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    final Queue<int[]> queue = new ArrayDeque<>();
    queue.add(start);
    while (!queue.isEmpty()) {
      final int[] startHere = queue.remove();
      if (visited[startHere[0]][startHere[1]]) {
        continue;
      }
      visited[startHere[0]][startHere[1]] = true;
      for (final int[] dir : DIRS) {
        int curRow = startHere[0], curCol = startHere[1];
        while (curRow < rows && curCol < cols && curCol >= 0 && curRow >= 0 &&
            maze[curRow][curCol] == 0) {
          curRow += dir[0];
          curCol += dir[1];
        }
        curRow -= dir[0];
        curCol -= dir[1];
        if (curRow == destination[0] && curCol == destination[1]) {
          return true;
        }
        queue.add(new int[] {curRow, curCol});
      }
    }
    return false;
  }

}
