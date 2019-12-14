package interviews.hulu._139_Word_Break;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    final int n = s.length();
    final boolean[] canReach = new boolean[1 + n];
    canReach[0] = true;
    for (int i = 0; i < n; ++i) {
      if (!canReach[i]) continue;
      for (final String word : wordDict) {
        if (s.startsWith(word, i) && i + word.length() <= n) {
          canReach[i + word.length()] = true;
        }
      }
    }
    return canReach[n];
  }
}
