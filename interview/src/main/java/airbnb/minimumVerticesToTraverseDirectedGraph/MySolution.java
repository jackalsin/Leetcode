package airbnb.minimumVerticesToTraverseDirectedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class MySolution implements Solution {
  /**
   * @param edges from to to
   * @param n     vertices number
   * @return
   */
  public List<Integer> getMin(int[][] edges, int n) {
    final int[] indegrees = new int[n];
    final Map<Integer, List<Integer>> map = new HashMap<>();
    for (int from = 0; from < n; from++) {
      for (int to = 0; to < n; to++) {
        if (edges[from][to] == 1) {
          map.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
          indegrees[to]++;
        }
      }
    }

//    System.out.println("Indegree: " + Arrays.toString(indegrees));
    final Set<Integer> resultSet = new HashSet<>();
    // loop the indegree = 0
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (indegrees[i] == 0) {
        resultSet.add(i);
        dfs(map, visited, i);
      }
    }

    // find remain
    final List<Integer> remain = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        assert (indegrees[i] != 0);
        remain.add(i);
      }
    }
//    System.out.println("Remain : " + remain);
    final int[] parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }

    for (int i : remain) {
      for (int j : remain) {
        if (edges[i][j] == 1 && i != j) {
          union(parents, i, j);
        }
      }
    }

    for (int i : remain) {
      resultSet.add(root(parents, i));
    }

    final List<Integer> result = new ArrayList<>(resultSet);
    Collections.sort(result);
    return result;
  }

  private void union(final int[] parents, int p, int q) {
    final int rootP = root(parents, p), rootQ = root(parents, q);
    if (rootQ == rootP) {
      return;
    }
    parents[rootQ] = rootP;
  }

  private static int root(final int[] parents, int p) {
    while (p != parents[p]) {
      parents[p] = parents[parents[p]];
      p = parents[p];
    }
    return p;
  }

  private static void dfs(final Map<Integer, List<Integer>> map, final Set<Integer> visited, final int i) {
    if (visited.contains(i)) {
      return;
    }
    visited.add(i);
    final List<Integer> children = map.getOrDefault(i, new ArrayList<>());
    for (int c : children) {
      dfs(map, visited, c);
    }
  }
}
