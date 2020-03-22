package interviews.google._939_Minimum_Area_Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minAreaRect(int[][] points) {
    final Map<Integer, List<Integer>> xToY = new HashMap<>();
    for (final int[] p : points) {
      xToY.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
    }
    final List<Integer> sortedKeys = new ArrayList<>(xToY.keySet());
    Collections.sort(sortedKeys);
    for (final Map.Entry<Integer, List<Integer>> e : xToY.entrySet()) {
      Collections.sort(e.getValue());
    }
    int minArea = Integer.MAX_VALUE;
//    System.out.println(xToY);
    for (int left = 0; left < sortedKeys.size(); ++left) {
      for (int right = left + 1; right < sortedKeys.size(); ++right) {
        final List<Integer> iY = xToY.get(sortedKeys.get(left)),
            jY = xToY.get(sortedKeys.get(right));
//        System.out.println(iY + ", " + jY);
        final int horizontal = sortedKeys.get(right) - sortedKeys.get(left);
        int prev = -1;
        for (int i = 0, j = 0; i < iY.size() && j < jY.size(); ) {
          final int iVal = iY.get(i), jVal = jY.get(j);
          if (iVal == jVal) {
            if (prev != -1) {
              final int cur = (iVal - prev) * horizontal;
              minArea = Math.min(cur, minArea);
            }
            prev = iVal;
            ++i;
            ++j;
          } else if (iVal < jVal) {
            ++i;
          } else {
            ++j;
          }
        }
      }
    }
    return minArea == Integer.MAX_VALUE ? 0 : minArea;
  }
}
