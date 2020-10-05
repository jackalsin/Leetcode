package hulu._347_Top_K_Frequent_Elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/6/2020
 */
public final class MapSolution implements Solution {
  @Override
  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (final int num : nums) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    final Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
    for (final Map.Entry<Integer, Integer> e : counts.entrySet()) {
      pq.add(e);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    final LinkedList<Integer> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove().getKey());
    }
    return result;
  }
}
