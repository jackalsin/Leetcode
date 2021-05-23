package dropbox._140_Word_Break_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/23/2021
 */
public final class SolutionI implements Solution {
  private final Map<Integer, List<String>> cache = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    return wordBreakHelper(s, wordDict, 0);
  }

  private List<String> wordBreakHelper(final String s, final List<String> wordDict, final int start) {
    if (cache.containsKey(start)) return cache.get(start);
    if (s.length() == start) return Collections.singletonList("");
    final List<String> result = new ArrayList<>();
    for (final String word : wordDict) {
      if (s.startsWith(word, start)) {
        final List<String> children = wordBreakHelper(s, wordDict, start + word.length());
        for (final String child : children) {
          final StringBuilder sb = new StringBuilder().append(word);
          sb.append(child.isEmpty() ? "" : " ").append(child);
          result.add(sb.toString());
        }
      }
    }
    cache.put(start, result);
    return result;
  }
}
