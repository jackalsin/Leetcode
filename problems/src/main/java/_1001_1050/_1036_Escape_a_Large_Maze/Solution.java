package _1001_1050._1036_Escape_a_Large_Maze;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public final class Solution {
  private static final int ROWS = (int) 1E6;
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
    if (blocked == null || blocked.length == 0) {
      return true;
    }
    final Set<Point> blocks = new HashSet<>();
    for (final int[] b : blocked) {
      blocks.add(new Point(b[0], b[1]));
    }
    return isSurrounded(blocks, source, target) && isSurrounded(blocks, target, source);
  }

  private static boolean isSurrounded(final Set<Point> blocks, final int[] source, final int[] target) {
    final Point start = new Point(source[0], source[1]), end = new Point(target[0], target[1]);
    final Set<Point> visited = new HashSet<>();
    final Queue<Point> q = new ArrayDeque<>();
    q.add(start);
    visited.add(start);
    int level = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final Point p = q.remove();
        for (final int[] d : DIRS) {
          final int nextX = p.x + d[0], nextY = p.y + d[1];
          if (isValid(nextX, nextY)) {
            final Point nextP = new Point(nextX, nextY);
            if (blocks.contains(nextP)) continue;
            if (nextP.equals(end)) return true;
            if (visited.contains(nextP)) continue;
            visited.add(nextP);
            q.add(nextP);
          }
        }
      } // end of for size
      if (blocks.size() - 1 < level) { //题目说了，最长200
        return true;
      }
      level++;
    }
    return false;
  }

  private static boolean isValid(final int nextX, final int nextY) {
    return nextX >= 0 && nextX < ROWS && nextY >= 0 && nextY < ROWS;
  }

  private static final class Point {
    private final int x, y;

    private Point(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final Point point = (Point) o;
      return x == point.x &&
          y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
