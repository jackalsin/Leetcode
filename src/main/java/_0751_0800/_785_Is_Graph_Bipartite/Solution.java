package _0751_0800._785_Is_Graph_Bipartite;

public class Solution {
  private static final int RED = 1, BLUE = -1, UNVISITED = 0;

  public boolean isBipartite(int[][] graph) {
    final int n = graph.length;
    final int[] colors = new int[n];
    for (int i = 0; i < n; i++) {
      if (colors[i] == UNVISITED) {
        if (!canColor(graph, colors, i, RED)) {
          return false;
        }
      }
    }
    return true;

  }

  private static boolean canColor(int[][] graph, final int[] colors, int nodeIndex, int color) {
    if (colors[nodeIndex] != UNVISITED) {
      return colors[nodeIndex] == color;
    }
    colors[nodeIndex] = color;
    final int otherColor = color == RED ? BLUE : RED;
    for (int neighbor : graph[nodeIndex]) {
      if (!canColor(graph, colors, neighbor, otherColor)) {
        return false;
      }
    }
    return true;
  }
}
