package linkedin._149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/20/2017.
 */
public final class SolutionI implements Solution {
  public int maxPoints(final int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    int max = 1;
    for (int i = 0; i < points.length - 1; ++i) {
      final int[] base = points[i];
      final Map<Long, Integer> ratioToCounts = new HashMap<>();
      int invalid = 0, self = 1;
      for (int j = i + 1; j < points.length; ++j) {
        int deltaX = points[j][0] - base[0], deltaY = points[j][1] - base[1];
        if (deltaX == 0) {
          if (deltaY == 0) {
            self++;
            for (Map.Entry<Long, Integer> entry : ratioToCounts.entrySet()) {
              max = Math.max(self + entry.getValue(), max);
            }
          } else {
            invalid++;
          }
          max = Math.max(self + invalid, max);
        } else {
          //y << 32 | x
          int gcd = gcd(deltaX, deltaY);
          int gcdY = deltaY / gcd, gcdX = deltaX / gcd;
          long slope = ((long) (gcdY)) << 32 ^ gcdX;
          int curCount = ratioToCounts.getOrDefault(slope, 0) + 1;
          max = Math.max(max, curCount + self);
          ratioToCounts.put(slope, curCount);
        }
      }
    }
    return max;
  }

  private static int gcd(int a, int b) {
    if (Math.abs(b) > Math.abs(a)) {
      return gcd(b, a);
    }
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
