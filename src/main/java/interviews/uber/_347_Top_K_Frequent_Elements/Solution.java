package interviews.uber._347_Top_K_Frequent_Elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : nums) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    final Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
            return Integer.compare(e1.getValue(), e2.getValue());
          }
        }
    );

    for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
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
}
