package _0951_1000._973_K_Closest_Points_to_Origin;

import java.util.PriorityQueue;
import java.util.Queue;

public final class PqSolution implements Solution {
  @Override
  public int[][] kClosest(int[][] points, int K) {
    if (K <= 0 || points == null) {
      return new int[][]{};
    }
    /*
    distance, index
     */
    final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
    for (int i = 0; i < points.length; ++i) {
      final int[] p = points[i];
      pq.add(new int[]{getDistance(p[0], p[1]), i});
      if (pq.size() > K) pq.remove();
    }
    final int[][] result = new int[K][2];
    for (int i = K - 1; i >= 0; --i) {
      final int index = pq.remove()[1];
      result[i] = points[index];
    }
    return result;
  }

  private static int getDistance(final int x, final int y) {
    return x * x + y * y;
  }
}
