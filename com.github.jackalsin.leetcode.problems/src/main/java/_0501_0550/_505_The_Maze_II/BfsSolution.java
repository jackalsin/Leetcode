package _0501_0550._505_The_Maze_II;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public final class BfsSolution implements Solution {
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
  private static final int NEVER_VISITED = -1;

  @Override
  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze.length == 0 || maze[0].length == 0) {
      return -1;
    }
    final int rows = maze.length, cols = maze[0].length;
    final int[][] minStartedHere = new int[rows][cols];
    for (final int[] child : minStartedHere) {
      Arrays.fill(child, NEVER_VISITED);
    }

    final Queue<int[]> queue = new ArrayDeque<>();
    queue.add(start);
    minStartedHere[start[0]][start[1]] = 0;
    while (!queue.isEmpty()) {
      final int[] curStart = queue.remove();
      final int curDistance = minStartedHere[curStart[0]][curStart[1]];
      for (final int[] dir : DIRS) {
        int curRow = curStart[0], curCol = curStart[1], curDirectionDist = curDistance;
        int steps = 0;
        while (curRow < rows && curCol < cols && curCol >= 0 && curRow >= 0
            && maze[curRow][curCol] == 0) {
          steps++;
          curRow += dir[0];
          curCol += dir[1];
        }
        curDirectionDist += steps - 1;
        curRow -= dir[0];
        curCol -= dir[1];
        if (minStartedHere[curRow][curCol] == NEVER_VISITED) {
          minStartedHere[curRow][curCol] = curDirectionDist;
          queue.add(new int[]{curRow, curCol});
        } else {
          if (curDirectionDist < minStartedHere[curRow][curCol]) {
            minStartedHere[curRow][curCol] = curDirectionDist;
            queue.add(new int[]{curRow, curCol});
          }
        }
      }
    }
    return minStartedHere[destination[0]][destination[1]];
  }
}
