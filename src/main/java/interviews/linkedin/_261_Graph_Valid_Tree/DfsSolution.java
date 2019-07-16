package interviews.linkedin._261_Graph_Valid_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/11/2019
 */
public final class DfsSolution implements Solution {
  @Override
  public boolean validTree(int n, int[][] edges) {
    if (n <= 0) {
      return false;
    }
    final Map<Integer, List<Integer>> adjs = getAdjacentList(n, edges);
    final boolean[] visited = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (!visited[i] && hasCycle(adjs, visited, i, -1)) {
        return false;
      }
    }
    return edges.length == n - 1;
  }

  private static boolean hasCycle(final Map<Integer, List<Integer>> map, final boolean[] visited,
                                  final int cur, final int parent) {
    visited[cur] = true;
    final List<Integer> adjacent = map.get(cur);
    for (int n : adjacent) {
      if (visited[n]) {
        if (n != parent) {
          return true;
        }
      } else if (hasCycle(map, visited, n, cur)) {
        return true;
      }
    }
    return false;
  }

  private static Map<Integer, List<Integer>> getAdjacentList(final int n, final int[][] edges) {
    final Map<Integer, List<Integer>> result = new HashMap<>();
    for (int i = 0; i < n; i++) {
      result.put(i, new ArrayList<>());
    }
    for (final int[] e : edges) {
      result.get(e[0]).add(e[1]);
      result.get(e[1]).add(e[0]);
    }
    return result;
  }
}
