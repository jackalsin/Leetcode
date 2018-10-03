package interviews.linkedin._139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  // TODO: 容易错
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return true;
    }
    final Set<String> wordSet = new HashSet<>(wordDict);
    final boolean[] dp = new boolean[s.length() + 1];
    dp[s.length()] = true;
    // exclusive end
    for (int end = s.length(); end >= 0; --end) {
      if (!dp[end]) continue;
      for (int start = end - 1; start >= 0; --start) {
        final String word = s.substring(start, end);
        if (wordSet.contains(word)) {
          dp[start] = true;
        }
      }
    }

    return dp[0];
  }
}
