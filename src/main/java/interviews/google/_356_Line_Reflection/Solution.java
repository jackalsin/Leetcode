package interviews.google._356_Line_Reflection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/15/2018.
 */
public class Solution {
  public boolean isReflected(int[][] points) {
    final Map<Integer, Set<Integer>> unmatched = new HashMap<>();
    for (final int[] point : points) {
      final Set<Integer> allX = unmatched.getOrDefault(point[1], new HashSet<>());
      if (allX.contains(-point[0])) {
        allX.remove(-point[0]);
      } else {
        allX.remove(point[0]);
      }
      if (allX.size() == 0) {
        unmatched.remove(point[1]);
      }
    }
    return unmatched.size() == 0;
  }
}
