package interviews.uber._140_Word_Break_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class SolutionI implements Solution {
  /**
   * start index to cache
   */
  private final Map<Integer, List<String>> cache = new HashMap<>();

  /**
   * Time complexity: O (
   * Time complexity is O(len(wordDict) ^ len(s / minWordLenInDict)), because there’re len(wordDict) possibilities
   * for each cut
   *
   * @param s
   * @param wordDict
   * @return
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    if (wordDict.isEmpty()) {
      return new ArrayList<>();
    }
    return wordBreak(s, wordDict, 0);
  }

  private List<String> wordBreak(String s, List<String> wordDict, int start) {
    final List<String> result = new ArrayList<>();
    if (cache.containsKey(start)) {
      return cache.get(start);
    }

    if (start == s.length()) {
      result.add("");
      return result;
    }

    for (final String word : wordDict) {
      if (s.startsWith(word, start)) {
        final List<String> candidates = wordBreak(s, wordDict, start + word.length());
        for (final String candidate : candidates) {
          result.add(word + (candidate.isEmpty() ? candidate : (" " + candidate)));
        }
      }
    }
    cache.put(start, result);
    return result;
  }
}
