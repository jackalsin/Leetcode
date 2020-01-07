package interviews.uber._218_The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 1/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> getSkyline(int[][] buildings) {
    final Map<Integer, List<int[]>> criticalPointToBuildings = new HashMap<>();
    for (final int[] b : buildings) {
      final int left = b[0], right = b[1], h = b[2];
      criticalPointToBuildings.computeIfAbsent(left, k -> new ArrayList<>()).add(b);
      criticalPointToBuildings.computeIfAbsent(right, k -> new ArrayList<>()).add(b);
    }
    final List<Integer> criticalPoints = new ArrayList<>(criticalPointToBuildings.keySet());
    Collections.sort(criticalPoints);
    final List<List<Integer>> result = new ArrayList<>();
    final TreeSet<int[]> pq = new TreeSet<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        final int heightCmp = Integer.compare(o1[2], o2[2]);
        if (heightCmp != 0) {
          return heightCmp;
        }
        final int leftCmp = Integer.compare(o1[0], o2[0]);
        if (leftCmp != 0) {
          return leftCmp;
        }
        return Integer.compare(o1[1], o2[1]);
      }
    });
    for (int cp : criticalPoints) {
      final List<int[]> buildingContainsCp = criticalPointToBuildings.get(cp);
      for (final int[] b : buildingContainsCp) {
        if (b[0] == cp) {
          pq.add(b);
        } else {
          pq.remove(b);
        }
      }
      if (pq.isEmpty()) {
        result.add(Arrays.asList(cp, 0));
      } else {
        final int h = pq.last()[2];
        if (result.isEmpty() || result.get(result.size() - 1).get(1) != h) {
          result.add(Arrays.asList(cp, h));
        }
      }
    }
    return result;
  }
}
