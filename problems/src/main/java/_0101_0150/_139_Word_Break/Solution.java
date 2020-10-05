package _0101_0150._139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Set<String> wordSet = new HashSet<>(wordDict);
    boolean[] hasWord = new boolean[s.length()];
    for (int start = s.length() - 1; start >= 0; start--) {
      for(int end = s.length(); end >= start; end--) {
        if (!hasWord[start]) {
          hasWord[start] = (end == s.length() || hasWord[end]) && wordSet.contains(s.substring
              (start, end));
        } else {
          break;
        }
      }
    }
    return hasWord[0];
  }
}
