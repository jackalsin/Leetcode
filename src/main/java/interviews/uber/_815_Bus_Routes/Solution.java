package interviews.uber._815_Bus_Routes;

import java.util.*;

public class Solution {
  public int numBusesToDestination(int[][] routes, int S, int T) {
    if (S == T) {
      return 0;
    }
    final Map<Integer, List<Integer>> stopToId = new HashMap<>();
    final int rows = routes.length;
    for (int routeId = 0; routeId < rows; routeId++) {
      final int[] route = routes[routeId];
      for (int col : route) {
//        stopToId.computeIfAbsent(col, x -> new ArrayList<>()).add(routeId);
        final List<Integer> stops = stopToId.getOrDefault(col, new ArrayList<>());
        stops.add(routeId);
        stopToId.put(col, stops);
      }
    }

    final Queue<Integer> q = new ArrayDeque<>();
    // 应当使用visitedRoutes，可以减少内存
//    final Set<Integer> visitedStops = new HashSet<>();
    final Set<Integer> visitedRoutes = new HashSet<>();
    q.add(S);
    int distance = 1;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final int toRemove = q.remove();
        final List<Integer> nextRouteIds = stopToId.get(toRemove);
        for (int nextRouteId : nextRouteIds) {
          if (visitedRoutes.contains(nextRouteId)) continue;
          visitedRoutes.add(nextRouteId);
          for (int nextStop : routes[nextRouteId]) {
            if (nextStop == T) {
              return distance;
            }
            q.add(nextStop);
          }
        }
      }
      distance++;
    }
    return -1;
  }
}
