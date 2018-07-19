package _851_900._854_K_Similar_Strings;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int kSimilarity(String A, String B) {
    if (A.equals(B)) {
      return 0;
    }
    final Queue<String> queue = new ArrayDeque<>();
    queue.add(A);
    final Map<String, Integer> cache = new HashMap<>();
    cache.put(A, 0);
    int swap = 0;
    while (!queue.isEmpty()) {
      final int size = queue.size();
      swap++;
      for (int i = 0; i < size; i++) {
        final String toRemove = queue.remove();
        final Set<String> neighbors = getNeighbors(toRemove, B);
        for (String neighbor : neighbors) {
          if (neighbor.equals(B)) {
            return swap;
          }

          if (!cache.containsKey(neighbor)) {
            queue.add(neighbor);
            cache.put(neighbor, swap);
          }
        }
      }
    }
    throw new IllegalStateException();
  }

  private static Set<String> getNeighbors(String s, String t) {
    final Set<String> res = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        // find all neighbors
        char[] sChars = s.toCharArray();
        for (int j = i + 1; j < t.length(); j++) {
          if (t.charAt(j) == s.charAt(i)) {
            swap(sChars, i, j);
            res.add(String.valueOf(sChars));
            swap(sChars, i, j);
          }
        }
        return res;
      }
    }
    throw new IllegalStateException();
  }

  private static void swap(final char[] chars, final int i, final int j) {
    final char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }
}
