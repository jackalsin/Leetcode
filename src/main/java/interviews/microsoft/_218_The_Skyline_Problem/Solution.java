package interviews.microsoft._218_The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Solution {
  public List<int[]> getSkyline(int[][] buildings) {
    final Map<Integer, List<int[]>> criticalPoints = getCriticalPoints(buildings);

    final List<int[]> result = new ArrayList<>();
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        final int height = Integer.compare(b[2], a[2]);

        return height;
      }
    });

    int height = 0;

    for (final Map.Entry<Integer, List<int[]>> entry : criticalPoints.entrySet()) {
      final int x = entry.getKey();
      final List<int[]> points = entry.getValue();
      for (int[] building : points) {
        if (x == building[0]) {
          pq.add(building);
        } else {
          pq.remove(building);
        }
      }

      if (pq.isEmpty()) {
        height = 0;
        if (result.isEmpty() || result.get(result.size() - 1)[1] != 0) {
          result.add(new int[]{x, height});
        }
      } else {
        final int[] maxHeightBuilding = pq.peek();
        if (maxHeightBuilding[2] != height) {
          height = maxHeightBuilding[2];
          result.add(new int[]{x, maxHeightBuilding[2]});
        }
      }
    }
    return result;
  }

  private TreeMap<Integer, List<int[]>> getCriticalPoints(int[][] buildings) {
    final TreeMap<Integer, List<int[]>> result = new TreeMap<>();

    for (final int[] building : buildings) {
      result.putIfAbsent(building[0], new ArrayList<>());
      result.putIfAbsent(building[1], new ArrayList<>());
      result.get(building[0]).add(building);
      result.get(building[1]).add(building);
    }

    return result;
  }

}
