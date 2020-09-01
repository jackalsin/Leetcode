package _0801_0850._808_Soup_Servings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
public final class SolutionI implements Solution {
  private final Map<Long, double[]> cache = new HashMap<>();
  private static final int[][] DIRS = {
      {100, 0}, {75, 25}, {50, 50}, {25, 75}
  };

  public double soupServings(int N) {
    if (N > 4800) return 1d;
    final double[] result = soupServings(N, N);
    return result[0] / 2 + result[1];
  }

  private double[] soupServings(final int A, final int B) {
    final long key = getKey(A, B);
    if (cache.containsKey(key)) return cache.get(key);
    final double[] result = new double[3];
    if (A == 0 && B == 0) {
      result[0] = 1;
    } else if (A == 0) {
      result[1] = 1;
    } else if (B == 0) {
      result[2] = 1;
    } else {
      for (final int[] d : DIRS) {
        final int nextA = Math.max(0, A - d[0]),
            nextB = Math.max(0, B - d[1]);
        final double[] toAdd = soupServings(nextA, nextB);
        result[0] += 0.25 * toAdd[0];
        result[1] += 0.25 * toAdd[1];
        result[2] += 0.25 * toAdd[2];
      }
      cache.put(key, result);
    }
    return result;
  }

  private static long getKey(final int A, final int B) {
    return (((long) A) << 32) | B;
  }
}
