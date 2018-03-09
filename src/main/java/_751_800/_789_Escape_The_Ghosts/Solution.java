package _751_800._789_Escape_The_Ghosts;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/8/2018.
 */
public class Solution {
  private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  private static final int G_VISITED = 1, S_VISITED = 2;

  public boolean escapeGhosts(int[][] ghosts, int[] target) {
    final Point targetPoint = new Point(target[0], target[1]);
    final int rows = ghosts.length, cols = ghosts[0].length;
    final Queue<Point> sourceQueue = new ArrayDeque<>(), ghostQueue = new ArrayDeque<>();
    final Set<Point> gVisited = new HashSet<>(), sVisited = new HashSet<>();
    gVisited.add(new Point(0, 0));
    sourceQueue.add(new Point(0, 0));
    for (final int[] g : ghosts) {
      final Point gPoint = new Point(g[0], g[1]);
      ghostQueue.add(gPoint);
      gVisited.add(gPoint);
    }
    while (!sourceQueue.isEmpty() || isSurrounded(targetPoint, gVisited)) {
      final int size = ghostQueue.size();
      for (int i = 0; i < size; i++) {
        final Point start = ghostQueue.remove();
        gVisited.add(start);
        for (final int[] dir : DIRS) {
          final int nextRow = start.x + dir[0], nextCol = start.y + dir[1];
          final Point nextPoint = new Point(nextRow, nextCol);
          if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols &&
              !gVisited.contains(nextPoint)) {
            ghostQueue.add(nextPoint);
          }
        }
      }

      final int sSize = sourceQueue.size();
      for (int i = 0; i < sSize; i++) {
        final Point start = sourceQueue.remove();
        if (start.equals(targetPoint)) {
          return true;
        }
        sVisited.add(start);
        for (final int[] dir : DIRS) {
          final int nextRow = start.x + dir[0], nextCol = start.y + dir[1];
          final Point nextPoint = new Point(nextRow, nextCol);
          if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols &&
              !gVisited.contains(nextPoint) && !sVisited.contains(nextPoint)) {
            sourceQueue.add(nextPoint);
          }
        }
      }
    }
    return false;
  }

  private boolean isSurrounded(Point targetPoint, Set<Point> gVisited) {
    for (final int[] dir : DIRS) {
      final int nextRow = targetPoint.x + dir[0], nextCol = targetPoint.y + dir[1];
      final Point p = new Point(nextRow, nextCol);
      if (0 <= nextRow && nextCol >= 0 && !gVisited.contains(p)) {
        return false;
      }
    }
    return true;
  }


  /**
   * Point class
   */
  private static final class Point {
    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }

    private final int x, y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Point)) {
        return false;
      }
      Point point = (Point) o;
      return x == point.x &&
          y == point.y;
    }

    @Override
    public int hashCode() {

      return Objects.hash(x, y);
    }
  }
}
