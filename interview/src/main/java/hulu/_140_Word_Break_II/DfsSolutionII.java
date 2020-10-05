package hulu._140_Word_Break_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/23/2020
 */
public final class DfsSolutionII implements Solution {
  private final Map<Integer, List<String>> cache = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, s.length(), (wordDict));
  }

  private List<String> wordBreak(final String s, final int end, final List<String> words) {
    if (end == 0) {
      return Arrays.asList("");
    }
    if (cache.containsKey(end)) {
      return cache.get(end);
    }
    final List<String> result = new ArrayList<>();
    for (final String word : words) {
      final int start = end - word.length();
      if (s.startsWith(word, start)) {
        final List<String> prefix = wordBreak(s, start, words);
        for (final String pre : prefix) {
          result.add(pre.isEmpty() ? word : pre + " " + word);
        }
      }
    }

    cache.put(end, result);
    return result;
  }
}
