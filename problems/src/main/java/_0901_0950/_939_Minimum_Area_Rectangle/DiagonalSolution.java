package _0901_0950._939_Minimum_Area_Rectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DiagonalSolution implements Solution {
  @Override
  public int minAreaRect(int[][] points) {
    final Map<Integer, Set<Integer>> xToY = new HashMap<>();

    for (final int[] p : points) {
      xToY.computeIfAbsent(p[0], key -> new HashSet<>()).add(p[1]);
    }
    long maxArea = Long.MAX_VALUE;

    for (int i = 0; i < points.length; ++i) {
      for (int j = i + 1; j < points.length; ++j) {
        final int[] p = points[i], q = points[j];
        if (p[0] == q[0] || p[1] == q[1]) continue;
        if (xToY.get(p[0]).contains(q[1]) && xToY.get(q[0]).contains(p[1])) {
          maxArea = Math.min(maxArea, Math.abs(p[0] - q[0]) * Math.abs(p[1] - q[1]));
        }
      }
    }
    return maxArea == Long.MAX_VALUE ? 0 : (int) maxArea;
  }
}
