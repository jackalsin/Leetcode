package interviews.newsbreak._499_The_Maze_III;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1}
  };
  private static final char[] DIRS_CHARS = {'d', 'u', 'r', 'l'};

  private static final int WALL = 1, EMPTY = 0;
  private static final String IMPOSSIBLE = "impossible";


  private int[][] maze;
  private State[][] visited;

  private int minLen = Integer.MAX_VALUE;
  private String minPath = null;

  public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
    if (maze == null || maze.length == 0) {
      return IMPOSSIBLE;
    }
    final int rows = maze.length, cols = maze[0].length;
    this.maze = maze;
    visited = new State[rows][cols];
    final Queue<State> q = new ArrayDeque<>();
    final State startState = new State(ball[0], ball[1], 0, "");
    visited[ball[0]][ball[1]] = startState;
    q.add(startState);
    while (!q.isEmpty()) {
      final State state = q.remove();
      if (visited[state.x][state.y] != null
          && (visited[state.x][state.y].distance != state.distance
          || !visited[state.x][state.y].path.equals(state.path))) continue; // no need to visit when is not min
      nextDir:
      for (int i = 0; i < 4; ++i) {
        final int[] d = DIRS[i];
        final String nextPath = state.path + DIRS_CHARS[i];
        int nextX = state.x, nextY = state.y, nextDistance = state.distance;
        while (nextX + d[0] >= 0 && nextX + d[0] < rows && nextY + d[1] >= 0 && nextY + d[1] < cols
            && maze[nextX + d[0]][nextY + d[1]] != WALL) {
          nextX += d[0];
          nextY += d[1];
          nextDistance++;
          if (nextX == hole[0] && nextY == hole[1]) {
            if (nextDistance < minLen || nextDistance == minLen && nextPath.compareTo(minPath) < 0) {
              minPath = nextPath;
              minLen = nextDistance;
            }
            continue nextDir;
          }
        }
        if (visited[nextX][nextY] == null
            || visited[nextX][nextY].distance > nextDistance
            || (visited[nextX][nextY].distance == nextDistance && visited[nextX][nextY].path.compareTo(nextPath) > 0)) {
          final State nextState = new State(nextX, nextY, nextDistance, nextPath);
          visited[nextX][nextY] = nextState;
          q.add(nextState);
        }
      }
    }
    return minPath == null ? IMPOSSIBLE : minPath;
  }

  private static final class State {
    private final int x, y, distance;
    private final String path;

    private State(int x, int y, int distance, String path) {
      this.x = x;
      this.y = y;
      this.distance = distance;
      this.path = path;
    }
  }
}
