package linkedin._149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIII implements Solution {
  @Override
  public int maxPoints(int[][] points) {
    if (points == null || points.length == 0) return 0;
    int max = 1;
    for (int i = 0; i < points.length; i++) {
      final int[] p0 = points[i];
      final int x0 = p0[0], y0 = p0[1];
      final Map<Long, Integer> ratioToCount = new HashMap<>();
      int self = 1, invalid = 0, curMaxInMap = 0;
      for (int j = i + 1; j < points.length; ++j) {
        final int[] p1 = points[j];
        final int x1 = p1[0], y1 = p1[1],
            dx = x1 - x0, dy = y1 - y0;
        if (dx == 0) {
          if (dy == 0) {
            self++;
          } else {
            invalid++;
          }
          max = max(max, self + curMaxInMap, invalid + self);
        } else {
          final int gcd = gcd(dx, dy),
              normalizedX = dx / gcd, normalizedY = dy / gcd;
          final long ratio = getKey(normalizedX, normalizedY);
          final int newCount = ratioToCount.getOrDefault(ratio, 0) + 1;
          ratioToCount.put(ratio, newCount);
          curMaxInMap = max(curMaxInMap, newCount);
          max = max(self + curMaxInMap, max);
        }
      }
    }
    return max;
  }

  private static int max(int a, final int... b) {
    for (int c : b) {
      a = Math.max(c, a);
    }
    return a;
  }

  private static int gcd(int a, int b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
  }

  /**
   * 这个方法风骚之处可以防止collision between (5, -2), (3, -2)
   */
  private static long getKey(final long a, final long b) {
    return a << 32 ^ b;
  }
}
