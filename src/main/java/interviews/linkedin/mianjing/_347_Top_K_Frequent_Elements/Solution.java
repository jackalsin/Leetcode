package interviews.linkedin.mianjing._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  /**
   * Time Complexity: O(N)
   *
   * @param nums
   * @param k
   * @return
   */
  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> freqCount = new HashMap<>();
    for (int num : nums) {
      freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
    }

    final List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i <= nums.length; ++i) {
      buckets.add(new ArrayList<>());
    }

    for (int key : freqCount.keySet()) {
      final int count = freqCount.get(key);
      buckets.get(count).add(key);
    }

    final List<Integer> result = new ArrayList<>();
    for (int i = nums.length; i >= 0 && result.size() < k; --i) {
      result.addAll(buckets.get(i));
    }
    return result;
  }
}
