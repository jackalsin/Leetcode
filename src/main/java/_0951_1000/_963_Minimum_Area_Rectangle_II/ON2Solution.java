package _0951_1000._963_Minimum_Area_Rectangle_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/3/2020
 */
public final class ON2Solution implements Solution {
  @Override
  public double minAreaFreeRect(int[][] points) {
    /*
    这其实是一个O(N^2)的solutoin，看起来最多可能有N^2在一个list中，但是每个key都是一个中心点和一个distance，
    理论上N个点对于一个中心点和一个distance，顶多只能有一个点对应，也就是每个list至多N/2个
     */
    final Map<String, List<int[]>> keyToDiag = new HashMap<>();
    for (int i = 0; i < points.length; ++i) {
      for (int j = i + 1; j < points.length; ++j) {
        final double centralX = ((double) points[i][0] + points[j][0]) / 2,
            centralY = ((double) points[i][1] + points[j][1]) / 2,
            dist = distance(points[i], points[j]);
        final String key = centralX + "," + centralY + "," + dist;
        keyToDiag.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{i, j});
      }
    }
    double min = Long.MAX_VALUE;
    for (final Map.Entry<String, List<int[]>> e : keyToDiag.entrySet()) {
      final List<int[]> list = e.getValue();
      if (list.size() > 1) {
        for (int i = 0; i < list.size(); ++i) {
          for (int j = i + 1; j < list.size(); ++j) {
            final int p1 = list.get(i)[0],
                p2 = list.get(i)[1],
                p3 = list.get(j)[0];
            final double len1 = distance(points[p1], points[p3]),
                len2 = distance(points[p2], points[p3]),
                curArea = len1 * len2;
            min = Math.min(curArea, min);
          }
        }
      }
    }
    return min == Long.MAX_VALUE ? 0 : min;
  }

  private static double distance(final int[] p1, final int[] p2) {
    final long deltaX = p1[0] - p2[0], deltaY = p1[1] - p2[1];
    return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
  }
}
