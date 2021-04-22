package facebook._140_Word_Break_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/20/2021
 */
public final class SolutionI implements Solution {
  private final Map<String, List<String>> cache = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    if (cache.containsKey(s)) {
      return cache.get(s);
    }
    if (s == null || s.isEmpty()) {
      return Collections.singletonList("");
    }
    final List<String> result = new ArrayList<>();
    for (String word : wordDict) {
      if (!s.startsWith(word)) continue;
      final List<String> suffixes = wordBreak(s.substring(word.length()), wordDict);
      for (final String suffix : suffixes) {
        if (suffix.isEmpty()) {
          result.add(word);
        } else {
          result.add(new StringBuilder().append(word).append(" ").append(suffix).toString());
        }
      }
    }
    cache.put(s, result);
    return result;
  }
}
