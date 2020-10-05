package airbnb._269_Alien_Dictionary;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/31/2019.
 */
public final class Solution {

  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) {
      return "";
    }
    final Map<Character, Integer> indegrees = getInDegrees(words);
    final Map<Character, Set<Character>> parentToChildren = new HashMap<>();
    for (int i = 0; i < words.length - 1; i++) {
      final String word1 = words[i], word2 = words[i + 1];
      final int min = Math.min(word1.length(), word2.length());
      for (int j = 0; j < min; j++) {
        final char c1 = word1.charAt(j), c2 = word2.charAt(j);
        if (c1 == c2) continue;
        final Set<Character> children = parentToChildren.getOrDefault(c1, new HashSet<>());
        parentToChildren.put(c1, children);
        if (!children.contains(c2)) {
          children.add(c2);
          indegrees.put(c2, indegrees.get(c2) + 1);
        }
        break;
      }
    } // end of for loop words
    final Queue<Character> q = new ArrayDeque<>();
    for (final Map.Entry<Character, Integer> e : indegrees.entrySet()) {
      if (e.getValue() == 0) {
        q.add(e.getKey());
      }
    }

    final StringBuilder result = new StringBuilder();
    while (!q.isEmpty()) {
      final char toRemove = q.remove();
      result.append(toRemove);
      final Set<Character> children = parentToChildren.get(toRemove);
      if (children == null) continue;
      for (char c : children) {
        final int count = indegrees.get(c);
        if (count == 1) {
          q.add(c);
        }
        indegrees.put(c, count - 1);
      }
    }
    return result.length() == indegrees.size() ? result.toString() : "";
  }

  private static Map<Character, Integer> getInDegrees(final String[] words) {
    final Map<Character, Integer> result = new HashMap<>();
    Arrays.stream(words).forEach(word -> word.chars().forEach(chr -> result.put((char) chr, 0)));
    return result;
  }
}
