package doordash._973_k_Closest_Points_to_Origin;

import java.util.PriorityQueue;
import java.util.Queue;

public final class PqSolutionI implements Solution {
  @Override
  public int[][] kClosest(int[][] points, int k) {
    if (points == null || k >= points.length) return points;
    final Queue<long[]> pq = new PriorityQueue<>((a, b) -> -Long.compare(a[0], b[0]));
    for (int i = 0; i < points.length; ++i) {
      final long d = getDistance(points[i]);
      pq.add(new long[]{d, i});
      if (pq.size() > k) pq.remove();
    }
    final int[][] res = new int[k][2];
    for (int i = k - 1; i >= 0; --i) {
      final int index = (int) (pq.remove()[1]);
      res[i] = points[index];
    }
    return res;
  }

  private static long getDistance(final int[] points) {
    final long x = points[0], y = points[1];
    return x * x + y * y;
  }
}
