package interviews.airbnb._815_Bus_Routes;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/16/2019.
 */
public final class Solution {
  public int numBusesToDestination(int[][] routes, int S, int T) {
    final Map<Integer, Set<Integer>> busStopToRouteIds = new HashMap<>();
    for (int routeId = 0; routeId < routes.length; routeId++) {
      for (int busStop : routes[routeId]) {
        final Set<Integer> buses = busStopToRouteIds.getOrDefault(busStop, new HashSet<>());
        buses.add(routeId);
        busStopToRouteIds.put(busStop, buses);
      }
    }
    final Queue<Integer> q = new ArrayDeque<>();
    final Set<Integer> visitedRouteIds = new HashSet<>();

    if (S == T) {
      return 0;
    }
    q.add(S);
    int distance = 0;
    while (!q.isEmpty()) {
      distance++;
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final int toRemove = q.remove();
        final Set<Integer> nextVisitedRouteIds = busStopToRouteIds.getOrDefault(toRemove, new HashSet<>());
        for (int routeId : nextVisitedRouteIds) {
          if (visitedRouteIds.contains(routeId)) continue;
          visitedRouteIds.add(routeId);
          for (int busStop : routes[routeId]) {
            if (busStop == T) {
              return distance;
            }
            q.add(busStop);
          }
        }
      }
    }
    return -1;
  }
}
