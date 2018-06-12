package interviews.pinterest._139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution { // todo: 在搞搞

  /**
   *
   * @param s
   * @param wordDict
   * @return
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    final boolean[] hasWord = new boolean[s.length()];
    final Set<String> wordSet = new HashSet<>(wordDict);
    for (int start = s.length() - 1; start >= 0; start--) {
      for (int end = start; end <= s.length(); end++) {
        if (!hasWord[start]) {
          hasWord[start] = (end == s.length() || hasWord[end]) && wordSet.contains(s.substring(start, end));
        }
      }
    }
    return hasWord[0];
  }
}
