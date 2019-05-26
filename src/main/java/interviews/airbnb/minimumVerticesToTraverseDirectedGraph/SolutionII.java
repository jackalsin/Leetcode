package interviews.airbnb.minimumVerticesToTraverseDirectedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionII implements Solution {
  @Override
  public List<Integer> getMin(int[][] edges, int n) {
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    final Map<Integer, Integer> indegrees = new HashMap<>();
    // get indegree
    for (int from = 0; from < n; from++) {
      for (int to = 0; to < n; to++) {
        indegrees.putIfAbsent(from, 0);
        indegrees.putIfAbsent(to, 0);
        if (edges[from][to] != 1) {
          continue;
        }
        final Set<Integer> children = parentToChildren.getOrDefault(from, new HashSet<>());
        parentToChildren.put(from, children);
        if (!children.contains(to)) {
          children.add(to);
          indegrees.put(to, indegrees.get(to) + 1);
        }
      }
    }
    final Set<Integer> resultSet = new HashSet<>();
    // loop indegree is zero
    final Set<Integer> remain = new HashSet<>(indegrees.keySet());
    for (final Map.Entry<Integer, Integer> e : indegrees.entrySet()) {
      if (e.getValue() == 0) {
        final int start = e.getKey();
        dfs(parentToChildren, remain, start, new HashSet<>());
        resultSet.add(start);
      }
    }

    // remain contains only the not visited;
    final int[] parents = new int[n];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    for (int i : remain) {
      for (int j : remain) {
        if (edges[i][j] == 1) {
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

  private void dfs(final Map<Integer, Set<Integer>> parentToChildren, final Set<Integer> remain,
                   final int cur, final Set<Integer> visited) {
    if (visited.contains(cur)) {
      return;
    }
    visited.add(cur);
    remain.remove(cur);
    final Set<Integer> children = parentToChildren.getOrDefault(cur, new HashSet<>());
    for (int c : children) {
      dfs(parentToChildren, remain, c, visited);
    }
  }
}
