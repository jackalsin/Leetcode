package interviews.airbnb._347_Top_K_Frequent_Elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/6/2019.
 */
public class Solution {

  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> count = new HashMap<>();
    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] i, int[] j) {
        return Integer.compare(i[1], j[1]);
      }
    });
    for (final Map.Entry<Integer, Integer> e : count.entrySet()) {
      pq.add(new int[]{e.getKey(), e.getValue()});
      if (pq.size() > k) {
        pq.remove();
      }
    }
    final LinkedList<Integer> res = new LinkedList<>();
    while (!pq.isEmpty()) {
      res.addFirst(pq.remove()[0]);
    }
    return res;
  }
}
