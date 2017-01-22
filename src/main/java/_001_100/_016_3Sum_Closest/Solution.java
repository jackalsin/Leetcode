package _001_100._016_3Sum_Closest;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2017/1/21.
 */
public class Solution {

  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) {
      throw new IllegalArgumentException("nums cannot be null or length smaller than 3");
    }

    Arrays.sort(nums);
    int sumWithMinDiff = nums[0] + nums[1] + nums[2]; // must be non-negative

    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(sumWithMinDiff - target) > Math.abs(sum - target)) {
          sumWithMinDiff = sum;
          if (sum == target) {
            return sum;
          }
        }
        if (sum > target) {
          right--;
        } else {
          left++;
        }
      }
    }
    return sumWithMinDiff;
  }
}
