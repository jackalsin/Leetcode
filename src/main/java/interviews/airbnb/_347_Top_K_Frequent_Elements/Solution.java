package interviews.airbnb._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/6/2019.
 */
public final class Solution {

  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int n : nums) {
      counts.put(n, counts.getOrDefault(n, 0) + 1);
    }

    final List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < nums.length + 1; i++) {
      buckets.add(new ArrayList<>());
    }

    for (final Map.Entry<Integer, Integer> e : counts.entrySet()) {
      final int key = e.getKey(), count = e.getValue();
      buckets.get(count).add(key);
    }
    final List<Integer> result = new ArrayList<>();
    for (int i = nums.length; result.size() < k && i >= 0; i--) {
      result.addAll(buckets.get(i));
    }
    assert result.size() == k;
    return result;
  }
}
