package interviews.airbnb._269_Alien_Dictionary;

import java.util.ArrayDeque;
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
    final Map<Character, Set<Character>> map = new HashMap<>();
    final Map<Character, Integer> indegree = new HashMap<>();
    for (String s : words) {
      for (char c : s.toCharArray()) {
        indegree.put(c, 0);
      }
    }
    for (int i = 0; i < words.length - 1; i++) {
      final String word1 = words[i], word2 = words[i + 1];
      final int min = Math.min(word1.length(), word2.length());
      for (int j = 0; j < min; j++) {
        final char c1 = word1.charAt(j), c2 = word2.charAt(j);
        if (c1 == c2) continue;
        final Set<Character> children = map.getOrDefault(c1, new HashSet<>());
        map.put(c1, children);
        if (!children.contains(c2)) {
          indegree.put(c2, indegree.get(c2) + 1);
          children.add(c2);
        }
        break;
      }
    }
    final Queue<Character> q = new ArrayDeque<>();
    for (final Map.Entry<Character, Integer> e : indegree.entrySet()) {
      if (e.getValue() == 0) {
        final char chr = e.getKey();
        q.add(chr);
      }
    }
    final StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      final char toRemove = q.remove();
      sb.append(toRemove);
      final Set<Character> children = map.getOrDefault(toRemove, new HashSet<>());
      for (char chr : children) {
        final int count = indegree.get(chr);
        if (count == 1) {
          q.add(chr);
        }
        indegree.put(chr, count - 1);
      }
    }
    return sb.length() == indegree.size() ? sb.toString() : "";
  }
}
