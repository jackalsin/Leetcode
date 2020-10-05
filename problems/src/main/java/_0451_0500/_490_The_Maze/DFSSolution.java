package _0451_0500._490_The_Maze;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 12/3/2017.
 */
public final class DFSSolution implements Solution {
  private final int[][] DIRS = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
  private static final int WALL = 1;

  /**
   * 78 / 78 test cases passed.
   * Status: Accepted
   * Runtime: 14 ms
   */
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze.length == 0 || maze[0].length == 0) {
      return false;
    }
    final int rows = maze.length, cols = maze[0].length;
    final boolean[][] startedHere = new boolean[rows][cols];
    return dfs(maze, startedHere, rows, cols, destination, start);
  }

  private boolean dfs(final int[][] maze, final boolean[][] startedHere, final int rows,
                      final int cols, final int[] destination, int[] start) {
    if (Arrays.equals(start, destination)) {
      return true;
    }
    if (startedHere[start[0]][start[1]]) {
      return false;
    }
    startedHere[start[0]][start[1]] = true;
    for (final int[] dir : DIRS) {
      int curRow = start[0], curCol = start[1];
      while (curRow >= 0 && curCol >= 0 && curRow < rows && curCol < cols
          && maze[curRow][curCol] != WALL) {
        curRow += dir[0];
        curCol += dir[1];
      }
      final boolean result = dfs(maze, startedHere, rows, cols, destination, new int[]{
          curRow - dir[0], curCol - dir[1]});
      if (result) {
        return true;
      }
    }
    return false;
  }
}
