package _0851_0900._874_Walking_Robot_Simulation;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
public final class SolutionI implements Solution {
  private final Set<Point> obstacles = new HashSet<>();
  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  public int robotSim(int[] commands, int[][] obstacles) {
    for (final int[] o : obstacles) {
      this.obstacles.add(new Point(o[0], o[1]));
    }
    int res = 0;
    final int[] pos = {0, 0};
    int dirIndex = 0;
    nextCommand:
    for (final int command : commands) {
      if (command < 0) {
        assert command == -1 || command == -2;
        if (command == -1) { // turn right
          dirIndex = (dirIndex + 1) % 4;
        } else { // turn left
          dirIndex = (dirIndex + 3) % 4;
        }
      } else {
        final int[] dir = DIRS[dirIndex];
        for (int step = 0; step < command; ++step) {
          final int nextX = pos[0] + dir[0], nextY = pos[1] + dir[1];
          final Point nextPoint = new Point(nextX, nextY);
          if (this.obstacles.contains(nextPoint)) {
            continue nextCommand;
          } else {
            pos[0] += dir[0];
            pos[1] += dir[1];
            res = Math.max(res, distance(pos[0], pos[1]));
          }
        }
      }
    }
    return res;
  }


  private static int distance(final int x, final int y) {
    return x * x + y * y;
  }

  private static final class Point {
    private final int x, y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Point)) return false;
      Point point = (Point) o;
      return x == point.x &&
          y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "[" + x + ", " + y + ']';
    }
  }
}

