package google._356_Line_Reflection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/15/2018.
 */
public class Solution {
  public boolean isReflected(int[][] points) {
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    final Set<String> occurred = new HashSet<>();
    for (final int[] point : points) {
      max = Math.max(point[0], max);
      min = Math.min(point[0], min);
      occurred.add(point[0] + ":" + point[1]);
    }
    final long sum = (long) max + (long) min;
    for (final int[] point : points) {
      final String matchPoint = (sum - point[0]) + ":" + point[1];
      if (!occurred.contains(matchPoint)) {
        return false;
      }
    }
    return true;
  }
}
