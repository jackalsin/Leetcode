package interviews.hulu._358_Rearrange_String_k_Distance_Apart;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/24/2020
 */
public final class SolutionIII implements Solution {
  @Override
  public String rearrangeString(String s, int k) {
    final Map<Character, Integer> charCount = new HashMap<>();
    for (final char chr : s.toCharArray()) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }
    final Queue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
          @Override
          public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            return Integer.compare(o2.getValue(), o1.getValue());
          }
        });
    pq.addAll(charCount.entrySet());
    final StringBuilder sb = new StringBuilder();
    final Queue<Map.Entry<Character, Integer>> q = new ArrayDeque<>();
    while (!pq.isEmpty()) {
      final Map.Entry<Character, Integer> toRemove = pq.remove();
      sb.append(toRemove.getKey());
      toRemove.setValue(toRemove.getValue() - 1);
      q.add(toRemove);
      if (q.size() >= k) {
        final Map.Entry<Character, Integer> toAdd = q.remove();
        if (toAdd.getValue() > 0) {
          pq.add(toAdd);
        }
      }
    }
    return sb.length() == s.length() ? sb.toString() : "";
  }
}
