package airbnb.minimumVerticesToTraverseDirectedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class UnionFindSolution implements Solution {
  /**
   * Time complexity: Max(V, E)
   *
   * @param edges
   * @param n
   * @return
   */
  @Override
  public List<Integer> getMin(int[][] edges, int n) {
    final int[] indegree = new int[n];
    final Map<Integer, List<Integer>> map = new HashMap<>();

    // Time complexity: O(E)
    for (int from = 0; from < n; from++) {
      for (int to = 0; to < n; to++) {
        if (edges[from][to] == 1) {
          indegree[to]++;
          map.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
        }
      }
    }
    final Set<Integer> resultSet = new HashSet<>();
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) { // O(V)
      if (indegree[i] == 0) {
        resultSet.add(i);
        dfs(map, visited, i);
      }
    }

    // 搞定loop
    final int[] parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
    final List<Integer> remain = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i) && indegree[i] != 0) {
        remain.add(i);
      }
    }

    for (int i : remain) {
      for (int j : remain) { // O(E)
        if (edges[i][j] == 1 && i != j) {
          union(parents, i, j);
        }
      }
    }

    for (int i : remain) { // O(V)
      resultSet.add(root(parents, i));
    }

    final List<Integer> result = new ArrayList<>(resultSet);
    Collections.sort(result);
    return result;
  }

  private static void union(final int[] parents, final int i, final int j) {
    final int p = root(parents, i), q = root(parents, j);
    if (p != q) {
      parents[p] = q;
    }
  }

  private static int root(final int[] parents, int j) {
    while (parents[j] != j) {
      j = parents[j];
    }
    return j;
  }

  private static void dfs(final Map<Integer, List<Integer>> map, final Set<Integer> visited, final int i) {
    if (visited.contains(i)) {
      return;
    }
    visited.add(i);
    for (int c : map.getOrDefault(i, new ArrayList<>())) {
      dfs(map, visited, c);
    }
  }
}
