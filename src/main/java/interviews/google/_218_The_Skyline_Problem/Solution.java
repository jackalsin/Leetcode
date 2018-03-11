package interviews.google._218_The_Skyline_Problem;

import java.util.*;

public class Solution {
  public List<int[]> getSkyline(int[][] buildings) {
    final Map<Integer, List<int[]>> criticalPoints = new TreeMap<>();
    for (final int[] building : buildings) {
      criticalPoints.putIfAbsent(building[0], new ArrayList<>());
      criticalPoints.putIfAbsent(building[1], new ArrayList<>());
      criticalPoints.get(building[0]).add(building);
      criticalPoints.get(building[1]).add(building);
    }

    final TreeSet<int[]> pq =
        new TreeSet<>(
            new Comparator<int[]>() {

              @Override
              public int compare(int[] i1, int[] i2) {
                final int cmp2 = Integer.compare(i2[2], i1[2]);
                if (cmp2 == 0) {
                  final int cmp1 = Integer.compare(i2[1], i1[1]);
                  if (cmp1 == 0) {
                    return Integer.compare(i2[0], i1[0]);
                  }
                  return cmp1;
                }
                return cmp2;
              }
            });
    final List<int[]> result = new ArrayList<>();
    for (final Map.Entry<Integer, List<int[]>> entry : criticalPoints.entrySet()) {
      final int cpLeft = entry.getKey();
      final List<int[]> edgeContainsCp = entry.getValue();
      for (final int[] child : edgeContainsCp) {
        if (cpLeft == child[0]) {
          pq.add(child);
        } else {
          pq.remove(child);
        }
      }
      if (pq.isEmpty()) {
        result.add(new int[] {cpLeft, 0});
      } else {
        int h = pq.first()[2];
        if (result.size() == 0 || h != result.get(result.size() - 1)[1])
          result.add(new int[] {cpLeft, h});
      }
    }
    return result;
  }
}
