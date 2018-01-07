package _751_800._753_Cracking_the_Safe;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/6/2018.
 */
public class DfsSolution implements Solution {

  /**
   * @param k k choice
   */
  public String crackSafe(int n, int k) {
    final int size = (int) Math.pow(k, n);
    final Set<String> visited = new HashSet<>();
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(0);
    }
    visited.add(sb.toString());
    dfs(sb, visited, size, n, k);
    return sb.toString();
  }

  private boolean dfs(final StringBuilder sb, final Set<String> visited, final int target,
                      final int n, final int k) {
    if (visited.size() == target) {
      return true;
    }
    System.out.println(visited.size());
    final String prefix = sb.substring(sb.length() - n + 1, sb.length());
    for (int i = 0; i < k; i++) {
      final String next = prefix + i;
      System.out.println("\t\tnext = " + next);
      if (!visited.contains(next)) {
        visited.add(next);
        sb.append(i);
        if (dfs(sb, visited, target, n, k)) {
          return true;
        }
        visited.remove(next);
        sb.delete(sb.length() - 1, sb.length());
      }
    }
    return false;
  }
}
