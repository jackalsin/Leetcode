package _0751_0800._753_Cracking_the_Safe;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/6/2018.
 */
public class DfsSolutionII implements Solution {
  private final Set<String> visited = new HashSet<>();
  private final StringBuilder sb = new StringBuilder();
  private int n, k, total;

  public String crackSafe(int n, int k) {
    this.n = n;
    this.k = k;
    total = (int) (Math.pow(k, n));
    for (int i = 0; i < n; i++) {
      sb.append('0');
    }
    visited.add(sb.toString());
    dfs(sb.substring(1));
    return sb.toString();
  }

  private boolean dfs(final String prev) {
    if (visited.size() == total) {
      return true;
    }
//    System.out.println(visited.size());
    for (int i = 0; i < k; i++) {
      String next = prev + i;
      if (!visited.contains(next)) {
        visited.add(next);
        sb.append(i);
        if (dfs(next.substring(1))) {
          return true;
        } else {
          visited.remove(next);
          sb.delete(sb.length() - 1, sb.length());
        }
      }
    }
    return false;
  }

}
