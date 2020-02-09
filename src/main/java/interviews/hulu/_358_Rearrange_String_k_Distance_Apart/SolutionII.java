package interviews.hulu._358_Rearrange_String_k_Distance_Apart;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public final class SolutionII implements Solution {
  @Override
  public String rearrangeString(String s, int k) {
    if (s == null || s.length() == 0 || k <= 0) {
      return s;
    }
    final char[] chars = s.toCharArray();
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (char chr : chars) {
      charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
    }
    final Queue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
          @Override
          public int compare(Map.Entry<Character, Integer> x, Map.Entry<Character, Integer> y) {
            return Integer.compare(y.getValue(), x.getValue());
          }
        });
    final StringBuilder sb = new StringBuilder();
    final Queue<Map.Entry<Character, Integer>> q = new ArrayDeque<>();
    pq.addAll(charCounts.entrySet());
    while (!pq.isEmpty()) {
      final Map.Entry<Character, Integer> toRemove = pq.remove();
      final char chr = toRemove.getKey();
      final int count = toRemove.getValue();
      if (count != 0) {
        sb.append(chr);
        toRemove.setValue(count - 1);
        q.add(toRemove);
        if (q.size() >= k) {
          pq.add(q.remove());
        }
      }
    }
    return sb.length() == s.length() ? sb.toString() : "";
  }
}
