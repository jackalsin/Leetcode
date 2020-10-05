package linkedin._347_Top_K_Frequent_Elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class PqSolutionI implements Solution {
  @Override
  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> count = getCount(nums);
    final PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,
        Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return Integer.compare(o1.getValue(), o2.getValue());
      }
    });

    for (final Map.Entry<Integer, Integer> e : count.entrySet()) {
      pq.add(e);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    final LinkedList<Integer> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.add(pq.remove().getKey());
    }
    return result;
  }

  private static Map<Integer, Integer> getCount(int[] nums) {
    final Map<Integer, Integer> result = new HashMap<>();
    for (int num : nums) {
      result.put(num, result.getOrDefault(num, 0) + 1);
    }
    return result;
  }
}
