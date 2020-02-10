package interviews.hulu._140_Word_Break_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jacka
 * @version 1.0 on 2/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> wordBreak(String s, List<String> wordDict) {
    final Set<String> wordSet = new HashSet<>(wordDict);
    final Set<String>[] cache = new Set[s.length() + 1];
    cache[s.length()] = new HashSet<>();
    cache[s.length()].add("");
    for (int end = s.length(); end >= 0; end--) {
      if (cache[end] == null || cache[end].isEmpty()) continue;
      for (final String word : wordSet) {
        final int start = end - word.length();
        if (s.startsWith(word, start)) {
          for (final String tail : cache[end]) {
            if (cache[start] == null) cache[start] = new HashSet<>();
            cache[start].add(word + " " + tail);
          }
        }
      }
    }
    if (cache[0] == null) return new ArrayList<>();
    return cache[0].stream().map(x -> x.substring(0, x.length() - 1)).collect(Collectors.toList());
  }
}
