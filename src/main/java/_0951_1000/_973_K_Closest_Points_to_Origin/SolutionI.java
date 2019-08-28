package _0951_1000._973_K_Closest_Points_to_Origin;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public final class SolutionI implements Solution {
  @Override
  public int[][] kClosest(int[][] points, int K) {
    if (K <= 0 || points == null) {
      return new int[][]{};
    }
    final Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Long.compare(getDistance(o1[0], o1[1]), getDistance(o2[0], o2[1]));
      }
    });
    for (final int[] p : points) {
      pq.add(p);
      if (pq.size() > K) {
        pq.remove();
      }
    }
    final LinkedList<int[]> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove());
    }
    return result.toArray(new int[][]{});
  }

  private static long getDistance(final int x, final int y) {
    return -(long) x * x - (long) y * y;
  }
}
