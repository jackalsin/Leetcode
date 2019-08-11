package interviews.linkedin._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/11/2019
 */
public final class BucketSortSolution implements Solution {
  @Override
  public List<Integer> topKFrequent(int[] nums, int k) {
    if (nums == null || k <= 0) {
      return new ArrayList<>();
    }
    final Map<Integer, Integer> valToCount = new HashMap<>();
    for (int num : nums) {
      valToCount.put(num, valToCount.getOrDefault(num, 0) + 1);
    }

    final List<List<Integer>> bucket = new ArrayList<>();
    for (int i = 0; i <= nums.length; ++i) {
      bucket.add(new ArrayList<>());
    }
    for (final Map.Entry<Integer, Integer> e : valToCount.entrySet()) {
      final int key = e.getKey(), count = e.getValue();
      bucket.get(count).add(key);
    }
    final List<Integer> result = new ArrayList<>();
    out:
    for (int i = nums.length; i >= 0; i--) {
      final List<Integer> keys = bucket.get(i);
      for (int key : keys) {
        if (result.size() < k) {
          result.add(key);
        } else {
          break out;
        }
      }
    }
    return result;
  }
}
