package _451_500._499_The_Maze_III;

import java.util.Arrays;

public class Solution {
  private static final String UP = "u", DOWN = "d", LEFT = "l", RIGHT = "r", IMPOSSIBLE = "impossible";
  private static final String[] DIRS_REPRESENT = {UP, DOWN, LEFT, RIGHT};
  private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static final int EMPTY = 0;

  public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
    final int rows = maze.length, cols = maze[0].length;
    final int[][] visited = new int[rows][cols];
    final StringBuilder curPath = new StringBuilder();
    boolean found = dfs(maze, visited, curPath, ball, hole);
    return found ? curPath.toString() : IMPOSSIBLE;
  }

  private static boolean dfs(final int[][] maze, final int[][] visited, final StringBuilder curPath, final int[] start, final int[] hole) {
    System.out.println(curPath);
    for (int i = 0; i < 4; i++) {
      final int[] dir = DIRS[i];
      visited[start[0]][start[1]] |= (1 << i);
      if (isValidDirection(maze, visited, start, i)) {
        curPath.append(DIRS_REPRESENT[i]);
        // roll until invalid
        final int[] next = new int[]{start[0], start[1]};
        while (isValidDirection(maze, visited, next, i)) {
          next[0] += dir[0];
          next[1] += dir[1];
          if (Arrays.equals(next, hole)) {
            return true;
          }
        }
        if (dfs(maze, visited, curPath, next, hole)) {
          return true;
        }
        curPath.setLength(curPath.length() - 1);
      }
    }
    return false;
  }

  private static boolean isValidDirection(final int[][] maze, final int[][] visited, final int[] start, final int dirIndex) {
    final int[] dir = DIRS[dirIndex];
    final int rows = maze.length, cols = maze[0].length;
    final int nextRow = start[0] + dir[0], nextCol = start[1] + dir[1];
    return nextRow >= 0 && nextRow < rows && 0 <= nextCol && nextCol < cols && ((visited[nextRow][nextCol] >> dirIndex) & 1) != 1 && maze[nextRow][nextCol] == EMPTY;
  }
}
