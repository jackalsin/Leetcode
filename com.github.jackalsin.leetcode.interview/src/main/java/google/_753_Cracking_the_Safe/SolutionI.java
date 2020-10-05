package google._753_Cracking_the_Safe;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/27/2020
 */
public final class SolutionI implements Solution {
  private final Set<Integer> visited = new HashSet<>();

  /**
   * @param n n digits
   * @param k k candidates
   * @return
   */
  public String crackSafe(int n, int k) {
    final int times = getTimes(n);
    final int goalSize = (int) Math.pow(k, n);
    final int start = 0;
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ++i) {
      sb.append('0');
    }
    visited.add(start);
    dfs(sb, goalSize, times, k, start, 1);
    return sb.toString();
  }

  private boolean dfs(final StringBuilder sb, final int goalSize, final int times, final int K, final int cur,
                      final int count) {
    if (count == goalSize) {
      return true;
    }
    final int len = sb.length();
    for (int i = 0; i < K; ++i) {
      final int next = cur * 10 % times + i;
      if (visited.contains(next)) continue;
      sb.append((char) ('0' + i));
      visited.add(next);
      if (dfs(sb, goalSize, times, K, next, count + 1)) {
//        sb.setLength(len);
        return true;
      }
      visited.remove(next);
      sb.setLength(len);
    }
    return false;
  }

  private static int getTimes(final int n) {
    int res = 1;
    for (int i = 0; i < n; ++i) {
      res *= 10;
    }
    return res;
  }
}
