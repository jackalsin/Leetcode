package interviews.linkedin._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/11/2019
 */
public final class PqSolution implements Solution {
  @Override
  public List<Integer> topKFrequent(int[] nums, int k) {
    if (nums == null || k <= 0) {
      return new ArrayList<>();
    }
    final Map<Integer, Integer> valToCount = new HashMap<>();
    for (int num : nums) {
      valToCount.put(num, valToCount.getOrDefault(num, 0) + 1);
    }
    final Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[1], o2[1]);
      }
    });

    for (final Map.Entry<Integer, Integer> e : valToCount.entrySet()) {
      final int key = e.getKey(), value = e.getValue();
      pq.add(new int[]{key, value});
      if (pq.size() > k) {
        pq.remove();
      }
    }
    final LinkedList<Integer> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove()[0]);
    }
    return result;
  }
}
