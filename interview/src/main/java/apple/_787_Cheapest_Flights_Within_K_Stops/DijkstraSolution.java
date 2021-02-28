package apple._787_Cheapest_Flights_Within_K_Stops;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/27/2021
 */
public final class DijkstraSolution implements Solution {
  private final Map<Integer, Map<Integer, Integer>> srcToDstToPrice = new HashMap<>();

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    for (final int[] f : flights) {
      final int s = f[0], t = f[1], p = f[2];
      srcToDstToPrice.computeIfAbsent(s, k -> new HashMap<>()).put(t, p);
    }
    // {src, price, remainStops}
    final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    if (src == dst) return 0;
    final Set<Integer> visited = new HashSet<>();
    pq.add(new int[]{src, 0, K + 1});
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int cur = toRemove[0], price = toRemove[1], remain = toRemove[2];
      visited.add(cur);
      if (cur == dst) {
        return price;
      }
      // visited?
      final Map<Integer, Integer> dstToPrice = srcToDstToPrice.get(cur);
      if (dstToPrice == null) continue;
      for (final Map.Entry<Integer, Integer> e : dstToPrice.entrySet()) {
        final int next = e.getKey(), nextPrice = price + e.getValue();
        if (remain > 0 && visited.contains(src)) {
          pq.add(new int[]{next, nextPrice, remain - 1});
        }
      }
    }

    return -1;
  }
}
