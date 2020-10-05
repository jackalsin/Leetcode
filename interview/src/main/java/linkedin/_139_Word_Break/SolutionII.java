package linkedin._139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionII implements Solution {

  public boolean wordBreak(String s, List<String> wordDict) {

    if (s == null || s.length() == 0) {
      return false;
    }
    final Set<String> wordSet = new HashSet<>(wordDict);
    final boolean[] dp = new boolean[s.length() + 1];
    dp[s.length()] = true;
    for (int end = s.length() - 1; end >= 0; end--) {
      if (!dp[end + 1]) continue;
      for (int start = end; start >= 0; start--) {
        final String word = s.substring(start, end + 1);
        if (wordSet.contains(word)) {
          dp[start] = true;
        }
      }
    }
    return dp[0];
  }
}
