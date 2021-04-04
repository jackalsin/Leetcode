package lime._560_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public final class SolutionI implements Solution {

  public int subarraySum(int[] nums, int k) {
    int sum = 0, count = 0;
    final Map<Integer, Integer> sumToCount = new HashMap<>();
    sumToCount.put(0, 1);
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      count += sumToCount.getOrDefault(sum - k, 0);
      sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
    }
    return count;

  }
}
