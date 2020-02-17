package interviews.tableau._785_Is_Graph_Bipartite;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  private static final int UNVISITED = 0,
      RED = 1,
      BLUE = 2;

  public boolean isBipartite(int[][] graph) {
    final int[] visited = new int[graph.length];
    for (int i = 0; i < graph.length; ++i) {
      if (visited[i] != UNVISITED) continue;
      if (!canColor(graph, visited, i, RED)) {
//        System.out.println("i = " + i + ", color = " + Arrays.toString(visited));
        return false;
      }
    }
    return true;
  }

  private boolean canColor(final int[][] graph, final int[] visited, final int i, final int color) {
    if (visited[i] == color) {
      return true;
    }
    if (visited[i] == otherColor(color)) {
      return false;
    }
    visited[i] = color;

    final int[] children = graph[i];
    for (final int c : children) {
      if (!canColor(graph, visited, c, otherColor(color))) {
        return false;
      }
    }
    return true;
  }

  private static int otherColor(final int c) {
    return c == RED ? BLUE : RED;
  }
}
