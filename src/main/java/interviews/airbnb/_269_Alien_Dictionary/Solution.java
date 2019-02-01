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
public class Solution {
  public String alienOrder(String[] words) {
    final Map<Character, Integer> childrenCounts = new HashMap<>();
    final Map<Character, Set<Character>> childToParents = new HashMap<>();
    for (String w : words) {
      for (char chr : w.toCharArray()) {
        childrenCounts.put(chr, 0);
      }
    }
    for (int i = 1; i < words.length; i++) {
      final String prev = words[i - 1], cur = words[i];
      for (int j = 0; j < Math.min(prev.length(), cur.length()); j++) {
        final char prevChar = prev.charAt(j), curChar = cur.charAt(j);
        if (prevChar != curChar) {
          childToParents.putIfAbsent(curChar, new HashSet<>());
          final Set<Character> parents = childToParents.get(curChar);
          childrenCounts.putIfAbsent(prevChar, 0);
          childrenCounts.putIfAbsent(curChar, 0);
          if (parents.add(prevChar)) {
            childrenCounts.put(prevChar, childrenCounts.get(prevChar) + 1);
          }
          break;
        }
      } // end of for j
    }
    final char[] res = new char[childrenCounts.size()];
    int index = res.length - 1;
    final Queue<Character> q = new ArrayDeque<>();
    final Set<Character> visited = new HashSet<>();
    for (final Map.Entry<Character, Integer> e : childrenCounts.entrySet()) {
      if (e.getValue() == 0) {
        final char key = e.getKey();
        q.add(key);
        visited.add(key);
      }
    }

    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final char toRemove = q.remove();
        res[index--] = toRemove;
        final Set<Character> parents = childToParents.getOrDefault(toRemove, new HashSet<>());
        for (char p : parents) {
          childrenCounts.put(p, childrenCounts.get(p) - 1);
          if (childrenCounts.get(p) == 0 && !visited.contains(p)) {
            q.add(p);
            visited.add(p);
          }
        }
      }
    }

    return index == -1 ? String.valueOf(res) : "";
  }
}
