package interviews.airbnb.MinimumVerticesToTraverseDirectedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Solution {
  public List<Integer> getMin(int[][] edges, int n) {
    final Map<Integer, Set<Integer>> fromToChildren = new HashMap<>();
    for (int from = 0; from < n; from++) {
      final Set<Integer> children = new HashSet<>();
      fromToChildren.put(from, children);
      for (int to = 0; to < n; to++) {
        if (edges[from][to] == 1) {
          children.add(to);
        }
      }
    } // end of for from;
    final Set<Integer> allVisited = new HashSet<>(),
        result = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (!allVisited.contains(i)) {
        result.add(i);
        dfs(fromToChildren, result, allVisited, new HashSet<>(), i, i);
      }
    }
    final List<Integer> resultList = new ArrayList<>(result);
    Collections.sort(resultList);
    return resultList;
  }

  private static void dfs(final Map<Integer, Set<Integer>> fromToChildren, final Set<Integer> result,
                          final Set<Integer> allVisited, final Set<Integer> curVisited, final int start, final int cur) {
    allVisited.add(cur);
    curVisited.add(cur);
    final Set<Integer> children = fromToChildren.get(cur);
    for (int c : children) {
      if (c != start) {
        result.remove(c);
      }
      if (!curVisited.contains(c)) {
        dfs(fromToChildren, result, allVisited, curVisited, start, c);
      }
    }
  }
}
