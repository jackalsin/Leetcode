package interviews.linkedin._547_Friend_Circles;

public final class DfsSolution implements Solution {
  @Override
  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0) {
      return 0;
    }
    final int n = M.length;
    int count = 0;
    final boolean[] visited = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        dfs(M, visited, i);
        count++;
      }
    }
    return count;
  }

  private static void dfs(final int[][] M, final boolean[] visited, final int start) {
    visited[start] = true;
    for (int i = 0; i < M.length; ++i) {
      if (visited[i]) continue;
      if (M[start][i] == 1) {
        visited[i] = true;
        dfs(M, visited, i);
      }
    }
  }
}
