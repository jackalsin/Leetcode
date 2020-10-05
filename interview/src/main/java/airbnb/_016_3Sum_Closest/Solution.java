package airbnb._016_3Sum_Closest;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    long bias = 2L * Integer.MAX_VALUE + 1;
    long minSum = 3L * Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {

      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        final long sum = nums[i] + nums[left] + nums[right];
        if (sum == target) {
          return target;
        } else {
          final long curBias = Math.abs(sum - target);
          if (bias > curBias) {
            bias = curBias;
            minSum = sum;
          }

          if (sum > target) {
            right--;
          } else {
            left++;
          }
        }
      }
    }
    return (int) minSum;
  }
}
