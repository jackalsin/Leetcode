package interviews.tableau._505_The_Maze_II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/20/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
  private static final int VISITED = 2;

  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze.length == 0 || maze[0].length == 0) {
      return -1;
    }
    final int rows = maze.length, cols = maze[0].length;
    final int[][] distances = new int[rows][cols];
    for (final int[] child : distances) {
      Arrays.fill(child, Integer.MAX_VALUE);
    }
    final Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[2], o2[2]);
      }
    });
    distances[start[0]][start[1]] = 0;
    q.add(new int[]{start[0], start[1], 0});
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int x = toRemove[0], y = toRemove[1], cur = toRemove[2];
      if (maze[x][y] == VISITED) continue;
      maze[x][y] = VISITED;
      if (x == destination[0] && destination[1] == y) {
        return distances[x][y];
      }
      for (final int[] d : DIRS) {
        final int dx = d[0], dy = d[1];
        int nextX = x, nextY = y, curDist = 0;
        while (nextX + dx < rows && nextY + dy < cols && nextY + dy >= 0 && nextX + dx >= 0
            && maze[nextX + dx][nextY + dy] != 1) {
          nextX += dx;
          nextY += dy;
          curDist += 1;
        }
        if ((long) cur + curDist < distances[nextX][nextY]) {
          distances[nextX][nextY] = cur + curDist;
          q.add(new int[]{nextX, nextY, curDist + cur});
        }
      }
    }
    return -1;
  }
}
