package _0551_0600._560_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/13/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int subarraySum(int[] nums, int k) {
    final Map<Integer, Integer> presumCount = new HashMap<>();
    int sum = 0;
    int res = 0;
    presumCount.put(sum, 1);
    for (int n : nums) {
      sum += n;
      final int target = sum - k;
      res += presumCount.getOrDefault(target, 0);
      presumCount.put(sum, presumCount.getOrDefault(sum, 0) + 1);
    }
    return res;
  }
}
