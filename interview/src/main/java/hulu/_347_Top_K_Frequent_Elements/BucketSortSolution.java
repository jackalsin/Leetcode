package hulu._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/6/2020
 */
public final class BucketSortSolution implements Solution {
  @Override
  public List<Integer> topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    final int n = nums.length;
    final Map<Integer, Integer> counts = new HashMap<>();
    for (final int num : nums) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    final List<Integer>[] buckets = new List[n + 1];
    for (final Map.Entry<Integer, Integer> e : counts.entrySet()) {
      final int key = e.getKey(), count = e.getValue();
      if (buckets[count] == null) {
        buckets[count] = new ArrayList<>();
      }
      buckets[count].add(key);
    }
    final LinkedList<Integer> result = new LinkedList<>();
    out:
    for (int i = n; i > 0; --i) {
      final List<Integer> bucket = buckets[i];
      if (bucket == null) continue;
      for (int num : bucket) {
        result.addFirst(num);
        if (result.size() == k) break out;
      }
    }
    return result;
  }
}
