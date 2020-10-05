package _0951_1000._963_Minimum_Area_Rectangle_II;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author zhixi
 * @version 1.0 on 4/3/2020
 */
public final class ON3Solution implements Solution {
  @Override
  public double minAreaFreeRect(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    final Set<Point> pointSet = new HashSet<>();
    for (final int[] p : points) {
      pointSet.add(new Point(p[0], p[1]));
    }

    double min = Long.MAX_VALUE;
    for (int i = 0; i < points.length; ++i) {
      final int[] p1 = points[i];
      for (int j = 0; j < points.length; ++j) {
        if (i == j) continue;
        final int[] p2 = points[j];
        for (int k = 0; k < points.length; ++k) {
          if (k == i || k == j) continue;
          final int[] p3 = points[k];
          final int distance12 = distance(p1, p2), distance23 = distance(p2, p3), distance13 = distance(p1, p3);
          // 直角检查
          if (distance12 + distance23 != distance13) {
            continue;
          }
          final int x = p1[0] + p3[0] - p2[0], y = p1[1] + p3[1] - p2[1];
          final Point point4 = new Point(x, y);
          if (!pointSet.contains(point4)) continue;
          final double cur = Math.sqrt(distance12) * Math.sqrt(distance23);
          min = Math.min(min, cur);
        }
      }
    }
    return min == Long.MAX_VALUE ? 0 : min;
  }

  private static int distance(final int[] p1, final int[] p2) {
    return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
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
      return String.format("[%d, %d]", x, y);
    }
  }
}
