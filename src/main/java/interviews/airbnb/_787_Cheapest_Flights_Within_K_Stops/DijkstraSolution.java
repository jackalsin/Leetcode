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
   * @return
   */
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    final Map<Integer, Map<Integer, Integer>> srcToDstToPrice = new HashMap<>();
    for (final int[] f : flights) {
      srcToDstToPrice.computeIfAbsent(f[0], k -> new HashMap<>()).put(f[1], f[2]);
    }
    if (!srcToDstToPrice.containsKey(src)) return -1;
    final Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        // 0: price, 1: nextDst, 2: remainStops
        return Integer.compare(o1[0], o2[0]);
      }
    });
    for (final Map.Entry<Integer, Integer> dstToPrice : srcToDstToPrice.get(src).entrySet()) {
      pq.add(new int[]{dstToPrice.getValue(), dstToPrice.getKey(), K});
    }

    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int price = toRemove[0], next = toRemove[1], remainStops = toRemove[2];
      if (next == dst) {
        return price;
      }
      if (remainStops == 0) continue;
      if (!srcToDstToPrice.containsKey(next)) continue;
      final Map<Integer, Integer> nextToPrice = srcToDstToPrice.get(next);
      for (final Map.Entry<Integer, Integer> e : nextToPrice.entrySet()) {
        pq.add(new int[]{e.getValue() + price, e.getKey(), remainStops - 1});
      }
    }
    return -1;
  }
}
