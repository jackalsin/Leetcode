package hulu._139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/23/2020
 */
public final class SolutionII implements Solution {
  @Override
  public boolean wordBreak(String s, List<String> wordDict) {
    final int n = s.length();
    final boolean[] canReach = new boolean[1 + n];
    final Set<String> wordSet = new HashSet<>(wordDict);
    canReach[n] = true;
    for (int end = n; end >= 0; end--) {
      if (!canReach[end]) continue;
      for (int start = 0; start < end; start++) {
        if (wordSet.contains(s.substring(start, end))) {
          canReach[start] = true;
        }
      }
    }
    return canReach[0];
  }
}
