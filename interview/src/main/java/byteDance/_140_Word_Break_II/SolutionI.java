package byteDance._140_Word_Break_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/23/2021
 */
public final class SolutionI implements Solution {
  private final Map<Integer, List<String>> cache = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    return wordDict(s, wordDict, s.length());
  }

  private List<String> wordDict(final String s, final List<String> wordDict, final int end) {
    if (end == 0) {
      return Collections.singletonList("");
    }
    if (cache.containsKey(end)) {
      return cache.get(end);
    }

    final List<String> result = new ArrayList<>();
    for (final String word : wordDict) {
      final int start = end - word.length();
      if (s.startsWith(word, start)) {
        final List<String> prefixes = wordDict(s, wordDict, start);
        for (final String prefix : prefixes) {
          final StringBuilder next = new StringBuilder().append(prefix);
          if (!prefix.isEmpty()) {
            next.append(" ");
          }
          next.append(word);
          result.add(next.toString());
        }
      }
    }
    cache.put(end, result);
    return result;
  }
}
