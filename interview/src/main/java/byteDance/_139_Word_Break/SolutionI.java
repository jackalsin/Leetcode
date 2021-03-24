package byteDance._139_Word_Break;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/23/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return true;
    }
    final int n = s.length();
    final boolean[] isReach = new boolean[n + 1];
    isReach[n] = true;
    for (int i = n; i >= 0; --i) {
      if (!isReach[i]) continue;
      for (final String word : wordDict) {
        final int m = word.length(), start = i - m;
        if (start >= 0 && s.startsWith(word, start)) {
          isReach[start] = true;
        }
      }
    }
    return isReach[0];
  }
}
