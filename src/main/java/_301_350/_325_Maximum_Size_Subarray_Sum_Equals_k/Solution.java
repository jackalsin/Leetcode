package _301_350._325_Maximum_Size_Subarray_Sum_Equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * Follow Up:
 * Can you do it in O(n) time?
 *
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public class Solution {
  /**
   * https://discuss.leetcode.com/topic/33259/o-n-super-clean-9-line-java-solution-with-hashmap
   *
   * @param nums
   * @param k
   * @return
   */
  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> sumToIndex = new HashMap<>();
    int sum = 0, maxLen = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (!sumToIndex.containsKey(sum)) {
        sumToIndex.put(sum, i);
      }
      sum += nums[i];
      if (sumToIndex.containsKey(sum - k)) {
        maxLen = Math.max(maxLen, i - sumToIndex.get(sum - k) + 1);
      }

    }
    return maxLen;
  }
}
