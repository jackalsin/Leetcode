package _0551_0600._593_Valid_Square;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class SolutionII implements Solution {
  @Override
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    final int p12 = getDistance(p1, p2),
        p13 = getDistance(p1, p3),
        p14 = getDistance(p1, p4),
        p23 = getDistance(p2, p3),
        p24 = getDistance(p2, p4),
        p34 = getDistance(p3, p4);
    final Set<Integer> seen = new HashSet<>() {{
      add(p12);
      add(p13);
      add(p14);
      add(p23);
      add(p24);
      add(p34);
    }};
    return seen.size() == 2 && !seen.contains(0);
  }

  private static int getDistance(final int[] a, final int[] b) {
    return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
  }
}
