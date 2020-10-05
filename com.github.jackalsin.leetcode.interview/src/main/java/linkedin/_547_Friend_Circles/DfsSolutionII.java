package linkedin._547_Friend_Circles;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/12/2019
 */
public final class DfsSolutionII implements Solution {
  @Override
  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0) {
      return 0;
    }

    final int n = M.length;
    final Set<Integer> visited = new HashSet<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) continue;
      dfs(M, visited, i, -1);
      count++;
    }
    return count;
  }

  private static void dfs(final int[][] M, final Set<Integer> visited, final int start, final int parent) {
    visited.add(start);
    for (int i = 0; i < M.length; i++) {
      if (M[start][i] == 0 || start == parent || visited.contains(i)) continue;
      dfs(M, visited, i, start);
    }
  }
}
