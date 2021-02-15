package _0101_0150._149_Max_Points_on_a_Line.April152019;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/4/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int maxPoints(int[][] points) {
    int max = 0;
    for (int i = 0; i < points.length; i++) {
      final int[] base = points[i];
      final Map<Long, Integer> ratioToCount = new HashMap<>();
      int invalid = 0, self = 1, curMax = 1;
      for (int j = i + 1; j < points.length; j++) {
        final int[] curPoint = points[j];
        final int deltaX = curPoint[0] - base[0], deltaY = curPoint[1] - base[1];
        if (deltaX == 0) {
          if (deltaY == 0) {
            self++;
            curMax++; // anyway, all needs go up by 1
          } else {
            invalid++;
            curMax = Math.max(curMax, invalid + self);
          }
        } else {
          final int common = gcd(deltaX, deltaY);
          final long key = getKey(deltaX / common, deltaY / common);
          final int curCount = ratioToCount.getOrDefault(key, 0) + 1;
          ratioToCount.put(key, curCount);
          curMax = Math.max(curMax, curCount + self);
        }
      }
      max = Math.max(max, curMax);
    }
    return max;
  }

  private static long getKey(final int a, final int b) {
    return (((long) a) << 32) | b;
  }

  private static int gcd(int a, int b) {
    while (b != 0) {
      final int c = a % b;
      a = b;
      b = c;
    }
    return a;
  }

  public static void main(final String[] args) {
    System.out.println("3 % -2 = " + (3 % -2));
    System.out.println("-3 % 2 = " + (-3 % 2));
    System.out.println("-3 % -2 = " + (-3 % -2));
  }
}
