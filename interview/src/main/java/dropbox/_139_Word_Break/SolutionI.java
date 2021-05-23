package dropbox._139_Word_Break;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/23/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) return true;
    final int n = s.length();
    final boolean[] canReach = new boolean[n + 1];
    canReach[0] = true;
    for (int start = 0; start < n; start++) {
      if (!canReach[start]) continue;
      for (final String word : wordDict) {
        if (s.startsWith(word, start)) {
          canReach[start + word.length()] = true;
        }
      }
    }
    return canReach[n];
  }
}

