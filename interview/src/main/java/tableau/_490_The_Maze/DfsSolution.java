package tableau._490_The_Maze;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/19/2020
 */
public final class DfsSolution implements Solution {
  @Override
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze.length == 0) {
      return true;
    }
    final int rows = maze.length, cols = maze[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    visited[start[0]][start[1]] = true;
    return dfs(maze, visited, destination, start);
  }

  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  private boolean dfs(final int[][] maze, final boolean[][] visited, final int[] destination, final int[] start) {
//    System.out.println("start " + Arrays.toString(start));
    if (Arrays.equals(destination, start)) {
      return true;
    }
    for (final int[] d : DIRS) {
      final int[] next = getNext(maze, start, d);
      if (visited[next[0]][next[1]]) continue;
      visited[next[0]][next[1]] = true;
      if (dfs(maze, visited, destination, next)) {
        return true;
      }
    }
    return false;
  }

  private static int[] getNext(final int[][] maze, final int[] start, final int[] d) {
    final int rows = maze.length, cols = maze[0].length, dx = d[0], dy = d[1];
    int x = start[0], y = start[1];
    while (x + dx >= 0 && x + dx < rows && y + dy >= 0 && y + dy < cols && maze[x + dx][y + dy] == 0) {
      x += dx;
      y += dy;
    }
    return new int[]{x, y};
  }
}
