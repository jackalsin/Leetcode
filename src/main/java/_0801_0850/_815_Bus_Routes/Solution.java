package _0801_0850._815_Bus_Routes;

import java.util.*;

public class Solution {
  public int numBusesToDestination(int[][] routes, int S, int T) {
    if (S == T) return 0;
    final Map<Integer, Set<Integer>> busStopToRoutesIndex = new HashMap<>();
    for (int i = 0; i < routes.length; ++i) {
      for (int j = 0; j < routes[i].length; ++j) {
        // TODO: replace to check performance
        busStopToRoutesIndex.computeIfAbsent(routes[i][j], k -> new HashSet<>()).add(i);
      }
    }

    final Set<Integer> visited = new HashSet<>();
    final Queue<Integer> q = new ArrayDeque<>();
    int level = 0;
    visited.add(S);
    q.add(S);
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int c = 0; c < size; ++c) {
        final int toRemove = q.remove();
        if (toRemove == T) return level;
        for (int i : busStopToRoutesIndex.get(toRemove)) {
          for (int j : routes[i]) {
            if (!visited.contains(j)) {
              visited.add(j);
              q.add(j);
            }
          }
        }
      }
      level++;
    }

    return -1;
  }
}
