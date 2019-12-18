package interviews.hulu._269_Alien_Dictionary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String alienOrder(String[] words) {
    final Map<Character, Set<Character>> parentToChildren = new HashMap<>();
    final Map<Character, Integer> indegrees = new HashMap<>();
    for (final String word : words) {
      for (char chr : word.toCharArray()) {
        indegrees.putIfAbsent(chr, 0);
      }
    }
    for (int i = 0; i < words.length - 1; ++i) {
      final int minLen = Math.min(words[i].length(), words[i + 1].length());
      for (int j = 0; j < minLen; ++j) {
        final char parent = words[i].charAt(j), child = words[i + 1].charAt(j);
        if (parent == child) continue;
        final boolean isNotExist = parentToChildren.computeIfAbsent(parent, k -> new HashSet<>()).add(child);
        if (isNotExist) {
          indegrees.put(child, indegrees.get(child) + 1);
        }
        break;
      }
    }
    final Queue<Character> q = new ArrayDeque<>();
    for (final Map.Entry<Character, Integer> e : indegrees.entrySet()) {
      if (e.getValue() == 0) {
        q.add(e.getKey());
      }
    }
    final StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      final char chr = q.remove();
      sb.append(chr);
      final Set<Character> children = parentToChildren.getOrDefault(chr, new HashSet<>());
      for (final char c : children) {
        final int prevCount = indegrees.get(c);
        if (prevCount == 1) {
          q.add(c);
        }
        indegrees.put(c, prevCount - 1);
      }
    }
    return sb.length() == indegrees.size() ? sb.toString() : "";
  }
}
