package interviews.linkedin._149_Max_Points_on_a_Line;

import utils.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/20/2017.
 */
public final class SolutionII implements Solution {
  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    if (points.length == 1) {
      return 1;
    }
    int max = 1;
    for (int i = 0; i < points.length; i++) {
      final Map<Long, Integer> ratioToCount = new HashMap<>();
      int self = 1, invalid = 0;
      for (int j = i + 1; j < points.length; j++) {
        final int deltaX = points[j].x - points[i].x, deltaY = points[j].y - points[i].y;
        if (deltaX == 0) {
          if (deltaY == 0) {
            self++;
            for (final Map.Entry<Long, Integer> entry : ratioToCount.entrySet()) {
              max = Math.max(self + entry.getValue(), max);
            }
          } else {
            invalid++;
            max = Math.max(invalid + self, max);
          }

        } else {
          System.out.println("Point j [" + points[j].x + ", " + points[j].y + "]");
          int gcd = gcd(deltaY, deltaX), gcdY = deltaY / gcd, gcdX = deltaX / gcd;
          long slope = ((long) gcdY) << 32 | gcdX;
          System.out.println("slope = " + slope);
          int curCount = ratioToCount.getOrDefault(slope, 0) + 1;
          max = Math.max(max, curCount + self);
          ratioToCount.put(slope, curCount);
        }
      }
    }
    return max;
  }

  private static int gcd(int a, int b) {
    // todo: add thoughts
    if (Math.abs(b) > Math.abs(a)) {
      return gcd(b, a);
    }
    if (b == 0) {
      return a;
    }

    return gcd(b, a % b);
  }
}
