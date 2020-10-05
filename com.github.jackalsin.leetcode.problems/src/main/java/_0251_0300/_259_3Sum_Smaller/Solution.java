package _0251_0300._259_3Sum_Smaller;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class Solution {
  /**
   * Discuss
   * Given an array of n integers nums and a target, find the number of index triplets i, j, k
   * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
   * For example, given nums = [-2, 0, 1, 3], and target = 2.
   * Return 2. Because there are two triplets which sums are less than 2:
   * [-2, 0, 1]
   * [-2, 0, 3]
   * Follow up:
   * Could you solve it in O(n2) runtime?
   * @param nums
   * @param target
   * @return
   */
  public int threeSumSmaller(int[] nums, final int target) {
    if (nums == null || nums.length < 3) {
      return 0;
    }
    Arrays.sort(nums);
    int count = 0;

    for (int start = 0; start < nums.length - 2; ++start) {
      int left = start + 1, right = nums.length - 1;
      while (left < right) {
        if (nums[start] + nums[left] + nums[right] < target) {
          count += right - left;
          left++;
        } else {
          right--;
        }
      }
    }
    return count;
  }
}
