package airbnb._787_Cheapest_Flights_Within_K_Stops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/5/2021
 */
public final class DijkstraSolutionI implements Solution {
  @Override
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    if (flights == null || flights.length == 0 || n < 0 || src == dst) return -1;
    final Map<Integer, List<int[]>> srcToDst = getMap(flights);
    /*
     * {to, k, cost}
     */
    final Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
    q.add(new int[]{src, K + 1, 0});
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int cur = toRemove[0], remain = toRemove[1], cost = toRemove[2];
      if (cur == dst) return cost;
      if (remain == 0) continue;
      final List<int[]> children = srcToDst.getOrDefault(cur, new ArrayList<>());
      for (final int[] c : children) {
        final int next = c[0], nextCost = cost + c[1];
        q.add(new int[]{next, remain - 1, nextCost});
      }
    }
    return -1;
  }

  private static Map<Integer, List<int[]>> getMap(final int[][] flights) {
    final Map<Integer, List<int[]>> result = new HashMap<>();
    for (final int[] flight : flights) {
      final int from = flight[0], to = flight[1], price = flight[2];
      result.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, price});
    }
    return result;
  }
}
