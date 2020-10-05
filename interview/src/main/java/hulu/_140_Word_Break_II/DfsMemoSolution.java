package hulu._140_Word_Break_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/10/2020
 */
public final class DfsMemoSolution implements Solution {
  private final Map<Integer, List<String>> cache = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    cache.put(0, new ArrayList<String>() {{
      add("");
    }});
    return wordBreak(s, new HashSet<>(wordDict), s.length());
  }

  private List<String> wordBreak(String s, final Set<String> wordDict, int i) {
    if (cache.containsKey(i)) {
      return cache.get(i);
    }
    final List<String> result = new ArrayList<>();
    for (final String word : wordDict) {
      final int start = i - word.length();
      if (s.startsWith(word, start)) {
        final List<String> prefixes = wordBreak(s, wordDict, start);
        for (final String prefix : prefixes) {
          result.add(prefix + (prefix.isEmpty() ? "" : " ") + word);
        }
      }
    }
    cache.put(i, result);
    return result;
  }
}
