package interviews.linkedin._261_Graph_Valid_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/30/2019
 */
public final class DfsSolutionI implements Solution {
  @Override
  public boolean validTree(int n, int[][] edges) {
    if (n <= 0 && edges == null) {
      return false;
    }
    final boolean[] visited = new boolean[n];
    final Map<Integer, List<Integer>> adjs = getAdjacentList(edges);
    for (int i = 0; i < n; i++) {
      if (visited[i]) continue;
      final boolean res = hasCycle(adjs, visited, i, -1);
      if (res) {
        return false;
      }
    }
    return edges.length == n - 1;
  }

  private static boolean hasCycle(final Map<Integer, List<Integer>> adjs, final boolean[] visited,
                                  final int cur, final int parent) {
    final List<Integer> neighbors = adjs.getOrDefault(cur, new ArrayList<>());
    for (final int next : neighbors) {
      if (next == parent) continue;
      if (visited[next]) return true;
      visited[next] = true;
      if (hasCycle(adjs, visited, next, cur)) {
        return true;
      }
    }
    return false;
  }

  private static Map<Integer, List<Integer>> getAdjacentList(final int[][] edges) {
    final Map<Integer, List<Integer>> result = new HashMap<>();
    for (final int[] e : edges) {
      result.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
      result.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
    }
    return result;
  }
}
