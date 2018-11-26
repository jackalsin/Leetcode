package _0801_0850._815_Bus_Routes;

import java.util.*;

public class Solution {
  public int numBusesToDestination(int[][] routes, int S, int T) {
    if (S == T) return 0;
    final Map<Integer, Node> keyToNode = new HashMap<>();
    for (int i = 0; i < routes.length; i++) {
      final int[] route = routes[i];
      for (int j = 1; j <= route.length; j++) {
        final int start = route[j - 1], end = j == route.length ? route[0] : route[j];
        keyToNode.computeIfAbsent(start, k -> new Node(start)).next.add(end);
        keyToNode.get(start).possibleBusRouteId.add(i);
      }
    } // end of for loop

    final Set<Long> visited = new HashSet<>();
//    final Map<Integer, Integer> visitedToBusCount = new HashMap<>();
    final Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

      @Override
      public int compare(int[] o1, int[] o2) {
        // [id, busTaken, cur route id]
        return Integer.compare(o1[1], o2[1]);
      }
    });
    final Node sNode = keyToNode.get(S);
    for (int route : sNode.possibleBusRouteId) {
      visited.add(getKey(route, S));
      pq.add(new int[]{S, 1, route});
    }

    while (!pq.isEmpty()) {
      final int[] curEntry = pq.remove();
      final int cur = curEntry[0], stop = curEntry[1], curRouteId = curEntry[2];
      if (cur == T) {
        return stop;
      }

      final Node curNode = keyToNode.get(cur);

      for (final int next : curNode.next) {
        final long nextKey = getKey(curRouteId, next);
        if (visited.contains(nextKey)) continue; // visited not working
        visited.add(nextKey);
        final Node nextNode = keyToNode.get(next);
        for (int nextRouteId : nextNode.possibleBusRouteId) {
          pq.add(new int[]{nextNode.id, stop + (nextRouteId == curRouteId ? 0 : 1), nextRouteId});
        }
      }

    }
    return -1; // not possible
  }

  private static final class Node {
    private final int id;
    private final Set<Integer> next = new HashSet<>(), possibleBusRouteId = new HashSet<>();

    private Node(int id) {
      this.id = id;
    }
  }

  private static long getKey(final int routeId, final int stopId) {
    long res = routeId;
    res = res << 32 | stopId;
    return res;
  }
}
