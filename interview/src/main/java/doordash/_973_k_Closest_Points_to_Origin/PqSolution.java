package doordash._973_k_Closest_Points_to_Origin;

import java.util.PriorityQueue;
import java.util.Queue;

public final class PqSolution implements Solution {
  @Override
  public int[][] kClosest(int[][] points, int k) {
    k = Math.min(k, points.length);
    final Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
    for (int i = 0; i < points.length; ++i) {
      final int[] p = points[i];
      pq.add(new long[]{getDistance(p[0], p[1]), i});
      if (pq.size() > k) pq.remove();
    }
    final int[][] result = new int[k][2];
    for (int i = k - 1; i >= 0; --i) {
      final int index = (int) (pq.remove()[1]);
      result[i] = points[index];
    }
    return result;
  }

  private static long getDistance(final long x, final long y) {
    return x * x + y * y;
  }
}
