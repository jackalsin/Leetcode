package _0501_0550._547_Friend_Circles;

public final class DFSSolution implements Solution {
  @Override
  public int findCircleNum(int[][] M) {
    final int n = M.length;
    assert 1 <= n && n <= 200;
    int count = 0;
    final boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(visited, M, i);
        count++;
      }
    }
    return count;
  }

  private static void dfs(final boolean[] visited, final int[][] M, final int start) {
    for (int i = 0; i < M.length; i++) {
      if (start != i && !visited[i] && M[i][start] == 1) {
        visited[i] = true;
        dfs(visited, M, i);
      }
    }
  }
}
