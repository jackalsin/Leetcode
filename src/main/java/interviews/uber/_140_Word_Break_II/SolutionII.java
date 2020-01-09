package interviews.uber._140_Word_Break_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/8/2020
 */

public final class SolutionII implements Solution {
  private final Map<Integer, List<String>> cache = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    if (s == null || wordDict == null || wordDict.size() == 0) {
      return new ArrayList<>();
    }
    return wordBreak(s, wordDict, 0);
  }

  private List<String> wordBreak(final String s, final List<String> wordDict, final int start) {
    if (cache.containsKey(start)) {
      return cache.get(start);
    }
    final List<String> result = new ArrayList<>();
    if (start == s.length()) {
      result.add("");
      return result;
    }
    for (final String word : wordDict) {
      if (s.startsWith(word, start)) {
        final List<String> nextSolution = wordBreak(s, wordDict, start + word.length());
        for (final String next : nextSolution) {
          result.add(next.isEmpty() ? word : (word + " " + next));
        }
      }
    }
    cache.put(start, result);
    return result;
  }
}
