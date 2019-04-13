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
    final Map<Integer, Map<Integer, Integer>> srcToDstToCost = getFlight(flights);
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(final int[] i, final int[] j) {
        return Integer.compare(i[1], j[1]);
      }
    });
    // city , cost, remainStop
    pq.add(new int[]{src, 0, K + 1});
    final Map<Integer, Integer> visited = new HashMap<>();
    visited.put(src, 0);
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int cur = toRemove[0], curCost = toRemove[1], curRemain = toRemove[2];
      if (cur == dst) {
        return curCost;
      }
      if (curRemain <= 0) {
        continue;
      }
      if (!srcToDstToCost.containsKey(cur)) continue;
      final Map<Integer, Integer> dstToCost = srcToDstToCost.get(cur);
      for (final Map.Entry<Integer, Integer> e : dstToCost.entrySet()) {
        final int next = e.getKey(), nextCost = e.getValue();
        if (visited.getOrDefault(next, Integer.MAX_VALUE) < curCost + nextCost) {
          continue; // no value to loop
        }
        pq.add(new int[]{next, curCost + nextCost, curRemain - 1});
      }
    }
    return -1;
  }

  private Map<Integer, Map<Integer, Integer>> getFlight(int[][] flights) {
    final Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
    for (final int[] f : flights) {
      result.computeIfAbsent(f[0], src -> new HashMap<>()).put(f[1], f[2]);
    }
    return result;
  }
}
