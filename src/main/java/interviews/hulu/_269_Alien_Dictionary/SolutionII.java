package interviews.hulu._269_Alien_Dictionary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/7/2020
 */
public final class SolutionII implements Solution {
  @Override
  public String alienOrder(String[] words) {
    final Map<Character, Set<Character>> parentToChildren = new HashMap<>();
    final Map<Character, Integer> incomingDegree = new HashMap<>();
    char[] prevChars = null;
    for (final String word : words) {
      final char[] chars = word.toCharArray();
      for (final char chr : chars) {
        parentToChildren.putIfAbsent(chr, new HashSet<>());
        incomingDegree.putIfAbsent(chr, 0);
      }
      if (prevChars != null) {
        for (int i = 0, len = Math.min(prevChars.length, chars.length); i < len; ++i) {
          final char prevChar = prevChars[i], curChar = chars[i];
          if (prevChar == curChar) continue;
          final Set<Character> children = parentToChildren.get(prevChar);
          if (!children.contains(curChar)) {
            children.add(curChar);
            incomingDegree.put(curChar, incomingDegree.getOrDefault(curChar, 0) + 1);
          }
          break;
        }
      }
      prevChars = chars;
    }
    final Queue<Character> q = new ArrayDeque<>();
    final StringBuilder sb = new StringBuilder();
    for (final Map.Entry<Character, Integer> e : incomingDegree.entrySet()) {
      if (e.getValue() == 0) {
        final char chr = e.getKey();
        q.add(chr);
        sb.append(chr);
      }
    }
    while (!q.isEmpty()) {
      final char chr = q.remove();
      final Set<Character> children = parentToChildren.get(chr);
      for (final char c : children) {
        final int prevCount = incomingDegree.get(c);
        if (prevCount == 1) {
          sb.append(c);
          q.add(c);
        }
        incomingDegree.put(c, prevCount - 1);
      }
    }
    System.out.println(sb);
    return sb.length() == incomingDegree.size() ? sb.toString() : "";
  }
}
