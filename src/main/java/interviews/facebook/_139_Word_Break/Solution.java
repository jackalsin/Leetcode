package interviews.facebook._139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public boolean wordBreak(String s, List<String> wordDict) {
    final Set<String> wordSet = new HashSet<>(wordDict);
    final boolean[] dp = new boolean[s.length() + 1];
    dp[s.length()] = true;
    for (int end = s.length(); end >= 0; end--) {
      if (!dp[end]) continue;
      for (int start = end - 1; start >= 0; start--) {
        if (wordSet.contains(s.substring(start, end))) {
          dp[start] = true;
        }
      }
    }
    return dp[0];
  }
}
