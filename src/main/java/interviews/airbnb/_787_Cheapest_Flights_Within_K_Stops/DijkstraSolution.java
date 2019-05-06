package interviews.airbnb._787_Cheapest_Flights_Within_K_Stops;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
public final class DijkstraSolution implements Solution {

  /**
   * @param n
   * @param flights [src, dst, price]
   * @param src
   * @param dst
   * @param K
   * @return the min cost
   */
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    final Map<Integer, Map<Integer, Integer>> srcToDstToCost = getFlightMap(flights);
    // {src, remain, price}
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[2], o2[2]);
      }
    });
    pq.add(new int[]{src, K + 1, 0});
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int cur = toRemove[0], remain = toRemove[1], cost = toRemove[2];
      if (cur == dst) return cost;
      if (remain == 0) continue;
      final Map<Integer, Integer> nextCostMap = srcToDstToCost.get(cur);
      if (nextCostMap == null) continue;
      for (Map.Entry<Integer, Integer> e : nextCostMap.entrySet()) {
        final int next = e.getKey(), nextCost = e.getValue();
        pq.add(new int[]{next, remain - 1, nextCost + cost});
      }
    }
    return -1;
  }

  private static Map<Integer, Map<Integer, Integer>> getFlightMap(final int[][] flights) {
    final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (final int[] f : flights) {
//      map.computeIfAbsent(f[0], x -> new HashMap<>()).put(f[1], f[2]);
      map.putIfAbsent(f[0], new HashMap<>());
      map.get(f[0]).put(f[1], f[2]);
    }
    return map;
  }
}
