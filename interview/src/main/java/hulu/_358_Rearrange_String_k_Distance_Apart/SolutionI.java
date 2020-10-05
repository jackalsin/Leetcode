package hulu._358_Rearrange_String_k_Distance_Apart;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 12/22/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String rearrangeString(String s, int k) {
    final Map<Character, Integer> charCount = new HashMap<>();
    final char[] chars = s.toCharArray();
    int max = 0;
    for (char chr : chars) {
      final int count = charCount.getOrDefault(chr, 0) + 1;
      charCount.put(chr, count);
      max = Math.max(count, max);
    }
    final Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character,
        Integer>>() {
      @Override
      public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return o2.getValue() - o1.getValue();
      }
    });
    final Queue<Map.Entry<Character, Integer>> q = new ArrayDeque<>();
    final StringBuilder sb = new StringBuilder();
    maxHeap.addAll(charCount.entrySet());
    while (!maxHeap.isEmpty()) {
      final Map.Entry<Character, Integer> toRemove = maxHeap.remove();
      final char chr = toRemove.getKey();
      final int count = toRemove.getValue();
      toRemove.setValue(count - 1);
      sb.append(chr);
      q.add(toRemove);
      if (q.size() < k) {
        continue;
      }
      final Map.Entry<Character, Integer> first = q.remove();
      if (first.getValue() != 0) {
        maxHeap.add(first);
      }
    }
    return sb.length() == s.length() ? sb.toString() : "";
  }
}
