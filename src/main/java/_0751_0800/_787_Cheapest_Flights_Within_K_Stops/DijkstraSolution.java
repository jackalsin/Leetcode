package _0751_0800._787_Cheapest_Flights_Within_K_Stops;

import java.util.*;

public final class DijkstraSolution implements Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    final Map<Integer, Map<Integer, Integer>> srcToDes = new HashMap<>();
    //The format of each flight will be (src, dst, price).
    for (final int[] f : flights) {
      srcToDes.computeIfAbsent(f[0], k -> new HashMap<>()).put(f[1], f[2]);
    }

    final Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

      @Override
      public int compare(int[] o1, int[] o2) {
        // 0 price
        // 1 next
        // 2 stops
        return Integer.compare(o1[0], o2[0]);
      }
    });

    pq.add(new int[]{0, src, K + 1});
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int curPrice = toRemove[0], next = toRemove[1], remainStops = toRemove[2];
      if (next == dst) {
        return curPrice;
      }
      if (remainStops == 0) continue;
      if (!srcToDes.containsKey(next)) continue;
      final Map<Integer, Integer> nextToPrice = srcToDes.get(next);
      for (final Map.Entry<Integer, Integer> entry : nextToPrice.entrySet()) {
        pq.add(new int[]{curPrice + entry.getValue(), entry.getKey(), remainStops - 1});
      }
    }

    return -1;
  }
}
