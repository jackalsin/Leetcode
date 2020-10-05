package _0551_0600._593_Valid_Square;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
public final class DistanceSolution implements Solution {
  @Override
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    final long p12 = distance(p1, p2),
        p13 = distance(p1, p3),
        p14 = distance(p1, p4),
        p23 = distance(p2, p3),
        p24 = distance(p2, p4),
        p34 = distance(p3, p4);
    final Set<Long> set = new HashSet<>();
    set.add(p12);
    set.add(p13);
    set.add(p14);
    set.add(p23);
    set.add(p24);
    set.add(p34);
    return set.size() == 2 && !set.contains(0L);
  }

  private static long distance(final int[] p, final int[] q) {
    final long deltaX = (long) p[0] - q[0],
        deltaY = (long) p[1] - q[1];
    return deltaX * deltaX + deltaY * deltaY;
  }

}
