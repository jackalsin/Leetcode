package linkedin._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class BucketSolutionI implements Solution {
  @Override
  public List<Integer> topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int num : nums) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    final List<Integer>[] buckets = new ArrayList[nums.length + 1];
    for (final Map.Entry<Integer, Integer> e : counts.entrySet()) {
      final int num = e.getKey(), count = e.getValue();
      if (buckets[count] == null) {
        buckets[count] = new ArrayList<>();
      }
      buckets[count].add(num);
    }

    final List<Integer> result = new ArrayList<>();
    out:
    for (int i = nums.length; i > 0; --i) {
      if (buckets[i] == null) continue;
      final List<Integer> curLine = buckets[i];
      for (int cur : curLine) {
        result.add(cur);
        if (result.size() == k) break out;
      }
    }
    return result;
  }
}
