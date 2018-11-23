package _0301_0350._347_Top_K_Frequent_Elements;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 10/7/2017.
 */
public class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    return mapSolution(nums, k);
//    return sortSolution(nums, k);
  }

  private List<Integer> mapSolution(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
    if (k == 0) {
      return result;
    }
    Map<Integer, Integer> digitCounts = new HashMap<>();
    for (int i : nums) {
      digitCounts.put(i, digitCounts.getOrDefault(i, 0) + 1);
    }

    Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,
        Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return Integer.compare(o1.getValue(), o2.getValue());
      }
    });

    for (Map.Entry<Integer, Integer> entry : digitCounts.entrySet()) {
      if (pq.size() == k) {
        if (pq.peek().getValue() < entry.getValue()) {
          pq.poll();
          pq.add(entry);
        }
      } else {
        pq.add(entry);
      }
    }
    while (!pq.isEmpty()) {
      result.add(pq.poll().getKey());
    }
    return result;
  }

  private List<Integer> sortSolution(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
    if (k == 0) {
      return result;
    }
    Map<Integer, Integer> digitCounts = new HashMap<>();
    int maxFreq = 0;
    for (int i : nums) {
      int freq = digitCounts.getOrDefault(i, 0) + 1;
      maxFreq = Math.max(freq, maxFreq);
      digitCounts.put(i, freq);
    }

    List<Integer>[] buckets = (List<Integer>[]) new Object[maxFreq + 1];
    for (Map.Entry<Integer, Integer> entry : digitCounts.entrySet()) {
      if (buckets[entry.getValue()] == null) {
        buckets[entry.getValue()] = new ArrayList<>();
      }
      buckets[entry.getValue()].add(entry.getValue());
    }

    for (int i = buckets.length - 1; i >= 0 && result.size() < k; --i) {
      if (buckets[i] != null) {
        result.addAll(buckets[i]);
      }
    }

    return result.subList(0, k);
  }
}
