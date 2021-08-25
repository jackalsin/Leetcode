package airbnb._269_Alien_Dictionary;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhixi
 * @version 1.0 on 8/24/2021
 */
public final class SolutionII implements Solution {
  @Override
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) return "";
    final Map<Character, Integer> indegrees = getInDegrees(words);
    final Map<Character, Set<Character>> map = new HashMap<>();
    for (int i = 0; i < words.length - 1; ++i) {
      final String word1 = words[i], word2 = words[i + 1];
      final int min = Math.min(word1.length(), word2.length());
      for (int j = 0; j < min; ++j) {
        final char c1 = word1.charAt(j), c2 = word2.charAt(j);
        if (c1 != c2) {
          if (map.computeIfAbsent(c1, k -> new HashSet<>()).add(c2)) {
            indegrees.put(c2, indegrees.get(c2) + 1);
          }
          break;
        }
        if (j == min - 1 && word1.length() > word2.length()) {
          return "";
        }
      }
    }
    final StringBuilder sb = new StringBuilder();
    final Queue<Character> q = new ArrayDeque<>();
    for (final var e : indegrees.entrySet()) {
      final char c = e.getKey();
      final int d = e.getValue();
      if (d == 0) {
        sb.append(c);
        q.add(c);
        e.setValue(-1);
      }
    }

    while (!q.isEmpty()) {
      final char toRemove = q.remove();
      for (final char next : map.getOrDefault(toRemove, Collections.emptySet())) {
        final int d = indegrees.get(next);
        if (d == -1) continue;
        if (d == 1) {
          indegrees.put(next, -1);
          q.add(next);
          sb.append(next);
        } else {
          indegrees.put(next, d - 1);
        }
      }
    }
    return sb.length() == indegrees.size() ? sb.toString() : "";
  }

  private static Map<Character, Integer> getInDegrees(final String[] words) {
    final Map<Character, Integer> result = new HashMap<>();
    Arrays.stream(words).forEach(word -> word.chars().forEach(chr -> result.put((char) chr, 0)));
    return result;
  }
}
