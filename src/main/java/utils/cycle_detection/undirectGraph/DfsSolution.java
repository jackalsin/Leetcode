package utils.cycle_detection.undirectGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/13/2019
 */
public final class DfsSolution implements Solution {
  @Override
  public boolean hasCycle(final int n, final int[][] edges) {
    if (edges == null || edges.length == 0) {
      return false;
    }
    final Map<Integer, List<Integer>> graph = getGraph(edges);
    final boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i] && hasCycle(graph, visited, i, -1)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasCycle(final Map<Integer, List<Integer>> graph, final boolean[] visited, final int cur,
                                  final int parent) {
    visited[cur] = true;
    final List<Integer> neighbors = graph.getOrDefault(cur, new ArrayList<>());
    for (int n : neighbors) {
      if (visited[n]) {
        if (n != parent) {
          return true;
        }
      } else if (hasCycle(graph, visited, n, cur)) {
        return true;
      }
    }
    return false;
  }

  private static Map<Integer, List<Integer>> getGraph(final int[][] edges) {
    final Map<Integer, List<Integer>> neighbors = new HashMap<>();
    Arrays.stream(edges).forEach(e -> {
      neighbors.computeIfAbsent(e[0], key -> new ArrayList<>()).add(e[1]);
      neighbors.computeIfAbsent(e[1], key -> new ArrayList<>()).add(e[0]);
    });
    return neighbors;
  }
}
