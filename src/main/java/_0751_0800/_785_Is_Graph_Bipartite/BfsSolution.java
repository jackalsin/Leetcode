package _0751_0800._785_Is_Graph_Bipartite;

import java.util.ArrayDeque;
import java.util.Queue;

public final class BfsSolution implements Solution {
  private static final int RED = 1, BLUE = -1, UNVISITED = 0;

  public boolean isBipartite(int[][] graph) {
    if (graph == null) {
      return false;
    }
    final int n = graph.length;
    final int[] colors = new int[n];
    for (int cur = 0; cur < n; cur++) {
      if (colors[cur] != UNVISITED) continue;
      final Queue<Integer> q = new ArrayDeque<>();
      q.add(cur);
      colors[cur] = RED;
      while (!q.isEmpty()) {
        final int toRemove = q.remove();
        for (int next : graph[toRemove]) {
          if (colors[next] == UNVISITED) {
            colors[next] = -colors[toRemove];
            q.add(next);
          } else if (colors[next] != -colors[toRemove]) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
