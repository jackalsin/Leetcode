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
    final boolean[] dp = new boolean[s.length()];
    for (int end = s.length() - 1; end >= 0; --end) {
      if (end + 1 < s.length() && !dp[end + 1]) continue;
      for (int start = end; start >= 0; --start) {
        if (wordSet.contains(s.substring(start, end + 1))) {
          dp[start] = true;
        }
      }
    }

    return dp[0];
  }
}
