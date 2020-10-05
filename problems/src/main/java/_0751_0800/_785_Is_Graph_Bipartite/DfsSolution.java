package _0751_0800._785_Is_Graph_Bipartite;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class DfsSolution implements Solution {
  private static final int RED = 1, BLUE = -1, UNVISITED = 0;

  public boolean isBipartite(int[][] graph) {
    if (graph == null) {
      return false;
    }
    final int n = graph.length;
    final int[] colors = new int[n];
    for (int i = 0; i < n; ++i) {
      if (colors[i] == 0 && !dfs(graph, colors, i, RED)) {
        return false;
      }
    }
    return true;
  }

  private static boolean dfs(final int[][] graph, final int[] colors, final int parent, final int color) {
    if (colors[parent] != UNVISITED) {
      return colors[parent] == color;
    }
    colors[parent] = color;
    for (final int next : graph[parent]) {
      if (!dfs(graph, colors, next, -color)) {
        return false;
      }
    }
    return true;
  }
}
