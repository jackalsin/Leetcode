package _0801_0850._815_Bus_Routes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  /**
   * 直接检查next是否是target，可以从15.96% ~ 47%
   * <p>
   * 将里面的Map里的<code>set</code>换成list，那么可以提升到97%
   *
   * @param routes
   * @param S
   * @param T
   * @return
   */
  public int numBusesToDestination(int[][] routes, int S, int T) {
    if (S == T) return 0;
    final Map<Integer, List<Integer>> busStopToRoutesIndex = new HashMap<>();
    for (int i = 0; i < routes.length; ++i) {
      for (int j = 0; j < routes[i].length; ++j) {
        final List<Integer> buses = busStopToRoutesIndex.getOrDefault(routes[i][j], new ArrayList<>());
        buses.add(i);
        busStopToRoutesIndex.put(routes[i][j], buses);
      }
    }

    final Set<Integer> visited = new HashSet<>();
    final Queue<Integer> q = new ArrayDeque<>();
    int level = 0;
    q.add(S);
    while (!q.isEmpty()) {
      level++;
      final int size = q.size();
      for (int c = 0; c < size; ++c) {
        final int toRemove = q.remove();
        final List<Integer> nextBuses = busStopToRoutesIndex.get(toRemove);
        for (int i : nextBuses) {
          if (visited.contains(i)) continue;
          visited.add(i);
          for (int j : routes[i]) {
            if (j == T) return level;
            q.add(j);
          }
        }
      }
    }

    return -1;
  }
}
