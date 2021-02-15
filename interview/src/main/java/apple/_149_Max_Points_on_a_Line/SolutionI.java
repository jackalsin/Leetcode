package apple._149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/13/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int maxPoints(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    int max = 1;
    for (int i = 0; i < points.length; ++i) {
      final int x0 = points[i][0], y0 = points[i][1];
      int same = 1, vertical = 0, maxRatioCount = 0;
      final Map<Long, Integer> ratioToCount = new HashMap<>();
      for (int j = i + 1; j < points.length; ++j) {
        final int x1 = points[j][0], y1 = points[j][1],
            dx = x1 - x0, dy = y1 - y0;
        if (dx == 0) {
          if (dy == 0) {
            same++;
            max = max(max, same + maxRatioCount);
          } else {
            vertical++;
            max = max(same + vertical, max);
          }
        } else {
          final long ratio = normalizedRatio(dy, dx);
          final int curCount = ratioToCount.getOrDefault(ratio, 0) + 1;
          ratioToCount.put(ratio, curCount);
          max = max(max, same + curCount);
          maxRatioCount = max(curCount, maxRatioCount);
        }
      } // for loop for j
    }
    return max;
  }

  private static int max(int a, final int... b) {
    for (int c : b) {
      a = Math.max(a, c);
    }
    return a;
  }

  private static long normalizedRatio(final int dy, final int dx) {
    assert dx != 0;
    final int gcd = Math.abs(gcd(dy, dx));
    final int sign = ((dy < 0 && dx > 0) || (dy >= 0 && dx < 0)) ? -1 : 1;
    final int y = sign * Math.abs(dy) / gcd, x = Math.abs(dx) / gcd;
    return ((long) y << 32) | x;
  }

  private static int gcd(int a, int b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
  }
}
