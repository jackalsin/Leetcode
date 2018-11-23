package _0501_0550._505_The_Maze_II;

import java.util.Arrays;

public class DfsWrongSolution implements Solution {
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
  private static final int NO_PATH = -1;
  private static final int NEVER_VISITED = -2;

  /**
   * Given the ball's start position, the destination and the maze, find the shortest distance
   * for the ball to stop at the destination. The distance is defined by the number of empty spaces
   * traveled by the ball from the start position (excluded) to the destination (included). If the
   * ball cannot stop at the destination, return -1.
   *
   * @param maze
   * @param start
   * @param destination
   * @return
   */
  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze.length == 0 || maze[0].length == 0) {
      return -1;
    }
    final int rows = maze.length, cols = maze[0].length;
    final int[][] minStartedHere = new int[rows][cols];
    for (final int[] child : minStartedHere) {
      Arrays.fill(child, NEVER_VISITED);
    }
    int res = dfs(maze, minStartedHere, destination, rows, cols, start);
//    TwoDimensionArray.display2DimensionArray(minStartedHere);
    return res;
  }

  private int dfs(final int[][] maze, final int[][] minStartedHere, final int[] destination, final int rows, final int cols,
                  final int[] start) {
    if (Arrays.equals(start, destination)) {
      return 0;
    }
    if (minStartedHere[start[0]][start[1]] != NEVER_VISITED) {
      return minStartedHere[start[0]][start[1]];
    }
    int minDistance = -1;
    minStartedHere[start[0]][start[1]] = minDistance;
    for (final int[] dir : DIRS) {
      int curRow = start[0], curCol = start[1];
      int curDist = 0;
      while (curCol >= 0 && curRow >= 0 && curRow < rows && curCol < cols && maze[curRow][curCol] == 0) {
        curDist++;
        curRow += dir[0];
        curCol += dir[1];
      }

      --curDist; // when you go from one cell to another cell, the distance is 1 rather than 2.
      int res = dfs(maze, minStartedHere, destination, rows, cols, new int[]{curRow - dir[0], curCol - dir[1]});
      if (res != NO_PATH) {
        curDist += res;
        if (minDistance == -1) {
          minDistance = curDist;
        } else {
          minDistance = Math.min(curDist, minDistance);
        }
      }
    }
    minStartedHere[start[0]][start[1]] = minDistance;
    return minDistance;
  }
}
