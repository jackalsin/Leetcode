package interviews.uber._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    final Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

    for (int n : nums) {
      frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    }

    final List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < nums.length + 1; i++) {
      buckets.add(new ArrayList<>());
    }

    for (final Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      buckets.get(entry.getValue()).add(entry.getKey());
    }
    final List<Integer> result = new ArrayList<>();
    for (int i = buckets.size() - 1; i >= 0 && result.size() < k; i--) {
      result.addAll(buckets.get(i));
    }
    return result;
  }
}
