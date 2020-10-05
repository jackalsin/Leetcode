package linkedin.mianjing._149_Max_Points_on_a_Line;

import definition.Point;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  @Override
  public int maxPoints(Point[] points) {
    if (points == null || points.length <= 2) {
      return points == null ? 0 : points.length;
    }
    int max = 0;
    for (int i = 0; i < points.length - 1; ++i) {
      final Map<Long, Integer> ratioToCount = new HashMap<>();
      final Point src = points[i];
      int self = 1, invalid = 0, localMax = 0, normalMax = 0;
      for (int j = i + 1; j < points.length; ++j) {
        final Point dst = points[j];
        if (src.x == dst.x) {
          if (src.y == dst.y) { // self
            self++;
            localMax = Math.max(self + invalid, self + normalMax);
          } else { // ratio is infinite
            invalid++;
            localMax = Math.max(localMax, invalid + self);
          }
        } else {
          final int deltaX = src.x - dst.x, deltaY = src.y - dst.y;
          int gcd = gcd(src.y - dst.y, src.x - dst.x);
          final int gcdY = deltaY / gcd, gcdX = deltaX / gcd;
          long ratio = (((long) (gcdY)) << 32) | ((long) gcdX);
          ratioToCount.put(ratio, ratioToCount.getOrDefault(ratio, 0) + 1);
//          System.out.println(ratio);
          normalMax = Math.max(normalMax, ratioToCount.get(ratio));
          localMax = Math.max(normalMax + self, localMax);
        }
      } // end of point y
//      System.out.println("i = " + i + ", local max = " + localMax);
      max = Math.max(max, localMax);
    }
    return max;
  }

  static int gcd(final int a, final int b) {
//    System.out.println("a = " + a + " b = " + b);

    int x = Math.abs(a), y = Math.abs(b);
    if (x < y) {
      return gcd(b, a);
    }
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
