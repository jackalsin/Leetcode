package interviews.oracle._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/14/2019
 */
public final class BucketSortSolution implements Solution {
  @Override
  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int n : nums) {
      counts.put(n, counts.getOrDefault(n, 0) + 1);
    }

    final List<Integer>[] buckets = new ArrayList[nums.length + 1];
    for (final Map.Entry<Integer, Integer> e : counts.entrySet()) {
      if (buckets[e.getValue()] == null) {
        buckets[e.getValue()] = new ArrayList<>();
      }
      buckets[e.getValue()].add(e.getKey());
    }
    final List<Integer> result = new ArrayList<>();
    out:
    for (int i = nums.length; i >= 0; --i) {
      if (buckets[i] == null) continue;
      for (int n : buckets[i]) {
        result.add(n);
        if (result.size() == k) {
          break out;
        }
      }
    }
    return result;
  }
}
