package _451_500._499_The_Maze_III;

import java.util.Arrays;

public class Solution {
  private static final String UP = "u", DOWN = "d", LEFT = "l", RIGHT = "r", IMPOSSIBLE = "impossible";
  private static final String[] DIRS_REPRESENT = {UP, LEFT, RIGHT, DOWN};
  private static final int[][] DIRS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
  private static final int EMPTY = 0;

  private int rows, cols;
  private int[][] shortestDist, maze;
  private int minDistance = Integer.MAX_VALUE;
  private String resultPath = null;

  /**
   * 64 / 64 test cases passed.
   * Status: Accepted
   * Runtime: 12 ms
   *
   * @param maze
   * @param ball
   * @param hole
   * @return
   */
  public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
    rows = maze.length;
    cols = maze[0].length;
    shortestDist = new int[rows][cols];
    for (final int[] row : shortestDist) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    this.maze = maze;
    final StringBuilder curPath = new StringBuilder();
    shortestDist[ball[0]][ball[1]] = 0;
    dfs(curPath, ball, hole, 0, 0);
    dfs(curPath, ball, hole, 0, 1);
    dfs(curPath, ball, hole, 0, 2);
    dfs(curPath, ball, hole, 0, 3);
    return resultPath == null ? IMPOSSIBLE : resultPath;
  }

  private void dfs(final StringBuilder curPath, final int[] start, final int[] hole, final int startDistance, final int preDirIndex) {
    // larger than cur ma, directly discard
    if (startDistance >= minDistance || startDistance > shortestDist[start[0]][start[1]]) {
      return;
    }
    dirForLoop:
    for (int i = 0; i < 4; i++) {
      if (preDirIndex == i || 3 - preDirIndex == i) {
        continue;
      }
      final int[] dir = DIRS[i];
      shortestDist[start[0]][start[1]] = Math.min(shortestDist[start[0]][start[1]], startDistance);
      if (isValidDirection(start, i)) {
        curPath.append(DIRS_REPRESENT[i]);
        // roll until invalid
        final int[] next = new int[]{start[0], start[1]};
        int nextDistance = startDistance;
        while (isValidDirection(next, i)) {
          next[0] += dir[0];
          next[1] += dir[1];
          nextDistance++;
          shortestDist[next[0]][next[1]] = Math.min(shortestDist[next[0]][next[1]], nextDistance);

          if (nextDistance > minDistance) {
            curPath.setLength(curPath.length() - 1);
            continue dirForLoop;
          }

          if (Arrays.equals(next, hole)) {
            assert nextDistance <= minDistance;
            if (nextDistance < minDistance) {
              minDistance = nextDistance;
              resultPath = curPath.toString();
            } else if (curPath.toString().compareTo(resultPath) < 0) {
              resultPath = curPath.toString();
            }
          }
        }
        dfs(curPath, next, hole, nextDistance, i);
//        System.out.println("\tBefore\"" + curPath + "\"");
        curPath.setLength(curPath.length() - 1);
      }
    }
  }

  private boolean isInRange(final int[] start, final int dirIndex) {
    final int[] dir = DIRS[dirIndex];
    final int rows = maze.length, cols = maze[0].length;
    final int nextRow = start[0] + dir[0], nextCol = start[1] + dir[1];
    return nextRow >= 0 && nextRow < rows && 0 <= nextCol && nextCol < cols;
  }

  private boolean isValidDirection(final int[] start, final int dirIndex) {
    final int[] dir = DIRS[dirIndex];
    final int nextRow = start[0] + dir[0], nextCol = start[1] + dir[1];
    return isInRange(start, dirIndex) && maze[nextRow][nextCol] == EMPTY;
  }
}
