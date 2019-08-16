package interviews.linkedin._547_Friend_Circles;

/**
 * @author jacka
 * @version 1.0 on 8/15/2019
 */
public final class DfsSolutionI implements Solution {
  @Override
  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0) {
      return 0;
    }
    final int rows = M.length;
    final boolean[] visited = new boolean[rows];
    int count = 0;
    for (int i = 0; i < rows; ++i) {
      if (visited[i]) continue;
      dfs(M, visited, i);
      count++;
    }
    return count;
  }

  private static void dfs(final int[][] M, final boolean[] visited, final int start) {
    visited[start] = true;
    for (int i = 0; i < M.length; ++i) {
      if (visited[i] || M[start][i] == 0) continue;
      visited[i] = true;
      dfs(M, visited, i);
    }
  }
}
