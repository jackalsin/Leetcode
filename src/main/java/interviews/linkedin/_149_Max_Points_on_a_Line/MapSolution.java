package interviews.linkedin._149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/27/2019
 */
public final class MapSolution implements Solution {
  @Override
  public int maxPoints(final int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    int max = 1;
    for (int i = 0; i < points.length; ++i) {
      final int[] p1 = points[i];
      final Map<Long, Integer> slopeToCount = new HashMap<>();
      int self = 1, invalid = 0, nonSelfMax = 0;
      for (int j = i + 1; j < points.length; ++j) {
        final int[] p2 = points[j];
        final int deltaX = p2[0] - p1[0], deltaY = p2[1] - p1[1];
        if (deltaX == 0) {
          if (deltaY == 0) {
            ++self;
            max = Math.max(max, nonSelfMax + self);
          } else {
            ++invalid;
            nonSelfMax = Math.max(nonSelfMax, invalid);
            max = Math.max(max, nonSelfMax + self);
          }
        } else {
          final int gcd = gcd(deltaX, deltaY);
          int gcdY = deltaY / gcd, gcdX = deltaX / gcd;
          long slope = ((long) (gcdY)) << 32 | gcdX;
          final int nextCount = slopeToCount.getOrDefault(slope, 0) + 1;
          slopeToCount.put(slope, nextCount);
          nonSelfMax = Math.max(nonSelfMax, nextCount);
          max = Math.max(nextCount + self, max);
        }
      }
    }
    return max;
  }

  private static int gcd(final int a, final int b) {
    if (Math.abs(b) > Math.abs(a)) {
      return gcd(b, a);
    }
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
