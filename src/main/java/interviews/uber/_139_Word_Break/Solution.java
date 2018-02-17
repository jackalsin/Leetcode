package interviews.uber._139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    final boolean[] f = new boolean[s.length() + 1];
    final Set<String> wordSet = new HashSet<>(wordDict);
    f[0] = true;
    for (int end = 1; end <= s.length(); end++) {
      for (int start = 0; start < end; start++) {
        if (f[start] && wordSet.contains(s.substring(start, end))) {
          f[end] = true;
          break;
        }
      }
    }
    return f[s.length()];
  }
}
