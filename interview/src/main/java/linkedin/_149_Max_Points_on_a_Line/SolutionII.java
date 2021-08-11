package linkedin._149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/20/2017.
 */
public final class SolutionII implements Solution { // 再搞搞
  public int maxPoints(final int[][] points) {
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
        final int deltaX = points[j][0] - points[i][0], deltaY = points[j][1] - points[i][1];
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
          int gcd = gcd(deltaY, deltaX), gcdY = deltaY / gcd, gcdX = deltaX / gcd;
          long slope = ((long) gcdY) << 32 ^ gcdX;
          int curCount = ratioToCount.getOrDefault(slope, 0) + 1;
          max = Math.max(max, curCount + self);
          ratioToCount.put(slope, curCount);
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
