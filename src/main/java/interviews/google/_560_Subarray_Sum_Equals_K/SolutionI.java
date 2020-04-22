package interviews.google._560_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/22/2020
 */
public final class SolutionI implements Solution {
  public int subarraySum(int[] nums, int k) {
    final Map<Integer, Integer> prefixSumToCount = new HashMap<>() {{
      put(0, 1);
    }};
    int res = 0, sum = 0;
    for (final int num : nums) {
      sum += num;
      final int count = prefixSumToCount.getOrDefault(sum - k, 0);
      res += count;
      prefixSumToCount.put(sum, prefixSumToCount.getOrDefault(sum, 0) + 1);
    }
    return res;
  }
}
