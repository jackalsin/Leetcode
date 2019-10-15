package interviews.oracle._347_Top_K_Frequent_Elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 10/14/2019
 */
public final class PqSolution implements Solution {
  @Override
  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int n : nums) {
      counts.put(n, counts.getOrDefault(n, 0) + 1);
    }
    final PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
          }
        }
    );
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
