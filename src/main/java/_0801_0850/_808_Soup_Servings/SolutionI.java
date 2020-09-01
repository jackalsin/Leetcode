package _0801_0850._808_Soup_Servings;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
public final class SolutionI implements Solution {
//  private final Map<Long, double[]> cache = new HashMap<>();
//  private static final int[][] DIRS = {
//      {100, 0}, {75, 25}, {50, 50}, {25, 75}
//  };

  private static final int[][] DIRS = {
      {4, 0}, {3, 1}, {2, 2}, {1, 3}
  };
  private final double[][] cache = new double[200][200];

  public double soupServings(int N) {
    if (N > 4800) return 1d;
    return soupServings((N + 24) / 25, (N + 24) / 25);
  }

  private double soupServings(final int A, final int B) {
    if (A <= 0 && B <= 0) {
      return 0.5;
    } else if (A <= 0) {
      return 1;
    } else if (B <= 0) {
      return 0;
    } else if (cache[A][B] > 0) {
      return cache[A][B];
    } else {
      cache[A][B] = 0.25 * (soupServings(A - 4, B) +
          soupServings(A - 3, B - 1) +
          soupServings(A - 2, B - 2) +
          soupServings(A - 1, B - 3)
      );
      return cache[A][B];
    }
  }
}
