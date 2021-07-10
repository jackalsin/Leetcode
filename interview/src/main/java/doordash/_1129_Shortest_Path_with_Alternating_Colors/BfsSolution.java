package doordash._1129_Shortest_Path_with_Alternating_Colors;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/8/2021
 */
public final class BfsSolution implements Solution {
  private static final int RED = 0, BLUE = 1;

  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    final Set<Integer>[][] graph = new HashSet[2][n];
    for (int i = 0; i < n; ++i) {
      graph[RED][i] = new HashSet<>();
      graph[BLUE][i] = new HashSet<>();
    }
    for (final int[] e : red_edges) {
      final int src = e[0], tgt = e[1];
      graph[RED][src].add(tgt);
    }
    for (final int[] e : blue_edges) {
      final int src = e[0], tgt = e[1];
      graph[BLUE][src].add(tgt);
    }

    final int[][] dp = new int[2][n];
    for (int i = 1; i < n; ++i) {
      dp[RED][i] = dp[BLUE][i] = 2 * n;
    }

    final Queue<int[]> q = new ArrayDeque<>() {{
      add(new int[]{0, RED});
      add(new int[]{0, BLUE});
    }};
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int vertex = toRemove[0],
          color = toRemove[1];
      for (final int next : graph[1 - color][vertex]) {
        if (dp[1 - color][next] != 2 * n) continue;
        dp[1 - color][next] = dp[color][vertex] + 1;
        q.add(new int[]{next, 1 - color});
      }
    }

    final int[] res = new int[n];
    for (int i = 0; i < n; ++i) {
      int t = Math.min(dp[BLUE][i], dp[RED][i]);
      res[i] = (t == 2 * n) ? -1 : t;
    }
    return res;
  }
}
