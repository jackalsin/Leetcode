package interviews.pinterest._140_Word_Break_II;

import java.util.*;

public class Solution {
  private final Map<String, List<String>> substringToPaths = new HashMap<>();

  /**
   * 39 / 39 test cases passed.
   * Status: Accepted
   * Runtime: 14 ms
   *
   * @param s
   * @param wordList
   * @return
   */
  public List<String> wordBreak(String s, List<String> wordList) {
    if (substringToPaths.containsKey(s)) {
      return substringToPaths.get(s);
    }
    if (s == null || s.isEmpty()) {
      return Collections.singletonList("");
    }
    final List<String> result = new ArrayList<>();
    for (final String word : wordList) {
      if (s.startsWith(word)) {
        final String next = s.substring(word.length());
        final List<String> nextResult = wordBreak(next, wordList);
        for (final String child : nextResult) {
          result.add(child.isEmpty() ? word : word + " " + child);
        }
      }
    }
    substringToPaths.put(s, result);
    return result;
  }
}
