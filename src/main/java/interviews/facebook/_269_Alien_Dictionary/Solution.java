package interviews.facebook._269_Alien_Dictionary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) {
      return "";
    } else if (words.length == 1) {
      return words[0];
    }

    final Map<Character, Set<Character>> parentToChildren = new HashMap<>();
    final Map<Character, Integer> parentCounts = new HashMap<>();

    for (final String w : words) {
      for (final char c : w.toCharArray()) {
        parentCounts.put(c, 0);
      }
    }

    for (int i = 1; i < words.length; i++) {
      final String word1 = words[i - 1], word2 = words[i];
      for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
        final char chr1 = word1.charAt(j), chr2 = word2.charAt(j);
        if (chr1 == chr2) continue;
        final Set<Character> candidates = parentToChildren.getOrDefault(chr1, new HashSet<>());
        if (!candidates.contains(chr2)) {
          candidates.add(chr2);
          parentCounts.put(chr2, parentCounts.getOrDefault(chr2, 0) + 1);
        }
        parentToChildren.put(chr1, candidates);
        break;
      }
    }

    final Queue<Character> queue = new ArrayDeque<>();
    for (Map.Entry<Character, Integer> entry : parentCounts.entrySet()) {
      if (entry.getValue() == 0) {
        queue.add(entry.getKey());
      }
    }
    final StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      final char curChar = queue.remove();
      sb.append(curChar);
      if (!parentToChildren.containsKey(curChar)) continue;
      final Set<Character> children = parentToChildren.get(curChar);
      for (Character child : children) {
        final int prevCount = parentCounts.get(child);
        if (prevCount == 1) {
          queue.add(child);
        }
        parentCounts.put(child, prevCount - 1);
      }
    }

    return sb.length() == parentCounts.size() ? sb.toString() : "";
  }
}
