package lime._149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/9/2021
 */
public final class SolutionI implements Solution {
  public int maxPoints(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    final int n = points.length;
    int max = 1;
    for (int i = 0; i < n; ++i) {
      final Map<Long, Integer> ratioToCount = new HashMap<>();
      int maxCountInMap = 0;
      final int x1 = points[i][0], y1 = points[i][1];
      int self = 1, invalid = 0;
      for (int j = i + 1; j < n; ++j) {
        final int x2 = points[j][0], y2 = points[j][1];
        if (x1 == x2) {
          if (y1 == y2) {
            self++;
          } else {
            invalid++;
          }
          max = Math.max(max, self + invalid);
          max = Math.max(max, self + maxCountInMap);
        } else {
          final int dx = x2 - x1, dy = y2 - y1,
              gcd = gcd(dx, dy),
              x = dx / gcd, y = dy / gcd;
          final long key = normalizedRatio(y, x);
          final int count = ratioToCount.getOrDefault(key, 0) + 1;
          ratioToCount.put(key, count);
          maxCountInMap = Math.max(maxCountInMap, count);
          max = Math.max(max, count + self);
        }
      }
    }
    return max;
  }

  private static long normalizedRatio(final int dy, final int dx) {
    assert dx != 0;
    final int gcd = Math.abs(gcd(dy, dx));
    final int sign = ((dy < 0 && dx > 0) || (dy >= 0 && dx < 0)) ? -1 : 1;
    final int y = sign * Math.abs(dy) / gcd, x = Math.abs(dx) / gcd;
    return ((long) y << 32) | x;
  }

  private static int gcd(int x, int y) {
    while (y != 0) {
      final int r = x % y;
      x = y;
      y = r;
    }
    return x;
  }

  private static long getKey(final int x, final int y) {
    return ((long) x) << 32 | (((long) y) & 0xFFFF);
  }

}
