package interviews.tableau._218_The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 2/14/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> getSkyline(int[][] buildings) {
    final TreeMap<Integer, List<int[]>> criticalPoints = getCriticalPoints(buildings);
    final TreeSet<int[]> pq = new TreeSet<>((a, b) -> {
      final int heightCmp = Integer.compare(b[2], a[2]);
      if (heightCmp != 0) {
        return heightCmp;
      }
      final int xCmp = Integer.compare(a[0], b[0]);
      if (xCmp != 0) {
        return xCmp;
      }
      return Integer.compare(a[1], b[1]);
    });
    final List<List<Integer>> result = new ArrayList<>();
    for (final Map.Entry<Integer, List<int[]>> e : criticalPoints.entrySet()) {
      final int x = e.getKey();
      final List<int[]> points = e.getValue();
      for (final int[] p : points) {
        if (p[0] == x) { // is a left point
          pq.add(p);
        } else {
          pq.remove(p);
        }
      }
      if (pq.isEmpty()) {
        result.add(Arrays.asList(x, 0));
      } else {
        final int curHeight = pq.first()[2];
        if (result.isEmpty() || result.get(result.size() - 1).get(1) != curHeight) {
          result.add(Arrays.asList(x, curHeight));
        }
      }
    }
    return result;
  }

  private static TreeMap<Integer, List<int[]>> getCriticalPoints(final int[][] buildings) {
    final TreeMap<Integer, List<int[]>> result = new TreeMap<>();
    for (final int[] b : buildings) {
      result.computeIfAbsent(b[0], k -> new ArrayList<>()).add(b);
      result.computeIfAbsent(b[1], k -> new ArrayList<>()).add(b);
    }
    return result;
  }
}
