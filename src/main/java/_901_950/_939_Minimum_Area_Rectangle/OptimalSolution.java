package _901_950._939_Minimum_Area_Rectangle;

import java.awt.*;
import java.util.List;
import java.util.*;

public final class OptimalSolution implements Solution {

  /**
   * Time complexity: O(N ^ 1.5)
   *
   * @param points
   * @return
   */
  @Override
  public int minAreaRect(int[][] points) {
    final Map<Integer, List<Integer>> xToY = new HashMap<>();

    for (final int[] p : points) {
      xToY.computeIfAbsent(p[0], key -> new ArrayList<>()).add(p[1]);
    }
    long maxArea = Long.MAX_VALUE;

    final Map<Point, Integer> sideToX = new HashMap<>();

    final List<Integer> xList = new ArrayList<>(xToY.keySet());
    for (int x : xList) {
      final List<Integer> candidatesY = xToY.get(x);
      Collections.sort(candidatesY);
      for (int i = 0; i < candidatesY.size(); ++i) {
        for (int j = i + 1; j < candidatesY.size(); ++j) {
          final int y1 = candidatesY.get(0), y2 = candidatesY.get(1);
          final Point side = new Point(y1, y2);
          if (sideToX.containsKey(side)) {
            maxArea = Math.min(maxArea, Math.abs(sideToX.get(side) - x) * (y2 - y1));
          }
          sideToX.put(side, x);
        }
      }
    }

    return maxArea == Long.MAX_VALUE ? 0 : (int) maxArea;
  }
}
