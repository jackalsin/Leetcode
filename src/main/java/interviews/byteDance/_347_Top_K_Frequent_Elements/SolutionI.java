package interviews.byteDance._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] topKFrequent(int[] nums, final int k) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    final int n = nums.length;
    final Map<Integer, Integer> valCounts = new HashMap<>();
    for (final int num : nums) {
      valCounts.put(num, valCounts.getOrDefault(num, 0) + 1);
    }
    final List<Integer>[] buckets = new List[n + 1];
    for (final var e : valCounts.entrySet()) {
      final int key = e.getKey(), count = e.getValue();
      if (buckets[count] == null) {
        buckets[count] = new ArrayList<>();
      }
      buckets[count].add(key);
    }
    final int[] result = new int[k];
    for (int i = n, j = 0; i >= 0 && j < k; --i) {
      if (buckets[i] == null) continue;
      for (int c : buckets[i]) {
        result[j++] = c;
      }
    }
    return result;
  }
}
