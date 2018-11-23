package _0551_0600._560_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/20/2017.
 */
public class Solution {
  public int subarraySum(int[] nums, int k) {
    final Map<Integer, Integer> preSumCount = new HashMap<>();
    int sum = 0, result = 0;
    preSumCount.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      result += preSumCount.getOrDefault(sum - k, 0);
      preSumCount.put(sum, preSumCount.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
}
