package interviews.google._593_Valid_Square;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    final Set<Long> distances = new HashSet<>();
    final long distance12 = getDistance(p1, p2),
        distance13 = getDistance(p1, p3),
        distance14 = getDistance(p1, p4),
        distance23 = getDistance(p2, p3),
        distance24 = getDistance(p2, p4),
        distance34 = getDistance(p3, p4);
    distances.add(distance12);
    distances.add(distance13);
    distances.add(distance14);
    distances.add(distance23);
    distances.add(distance24);
    distances.add(distance34);
    return distances.size() == 2 && !distances.contains(0L);
  }

  private long getDistance(final int[] p1, final int[] p2) {
    return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
  }
}
