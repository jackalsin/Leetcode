package _0851_0900._886_Possible_Bipartition;

/**
 * @author jacka
 * @version 1.0 on 5/27/2020
 */
public final class SolutionI implements Solution {
  private static final int GROUP_A = 1, GROUP_B = -1, UNVISITED = 0;
  private boolean[][] graph;

  public boolean possibleBipartition(int N, int[][] dislikes) {
    if (dislikes == null || dislikes.length == 0) {
      return true;
    }
    graph = new boolean[N][N];
    for (final int[] d : dislikes) {
      final int i = d[0], j = d[1];
      graph[i - 1][j - 1] = true;
      graph[j - 1][i - 1] = true;
    }
    final int[] visited = new int[N];
    for (int i = 0; i < N; ++i) {
      if (visited[i] == UNVISITED && !dfs(visited, i, GROUP_A)) {
//        System.out.println(Arrays.toString(visited));
        return false;
      }
    }
//    System.out.println(Arrays.toString(visited));
    return true;
  }

  private boolean dfs(final int[] visited, final int i, final int color) {
    if (visited[i] != UNVISITED) {
      if (visited[i] == color) return true;
//      System.out.println("i = " + i + " failed");
      return false;
    }
    visited[i] = color;
    for (int next = 0; next < graph.length; ++next) {
      if (graph[i][next]) {
        if (!dfs(visited, next, otherColor(color))) {
          return false;
        }
      }
    } // end of out for
    return true;
  }

  private static int otherColor(int color) {
    return color == GROUP_A ? GROUP_B : GROUP_A;
  }
}
