package _701_750._719_Find_K_th_Smallest_Pair_Distance;

import java.util.Arrays;

public class Solution {

  /**
   * The correct pair count for {1, 1, 3, 7}
   * {1, 1} = 0, {1, 3} = 2, {1, 7} = 6, {1, 3} = 2
   * {1, 7} = 6, {3, 7} = 4
   *
   * @param nums
   * @param k
   * @return
   */
  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      min = Math.min(min, nums[i] - nums[i - 1]);
    }
    int max = nums[nums.length - 1] - nums[0];

    while (min < max) {
      int mid = min + (max - min) / 2;
      int count = getCount(nums, mid);
      if (count < k) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return min;
  }

  /**
   * Return the count smaller than or equal to <t>target</t>
   *
   * @param nums   original array
   * @param target
   * @return
   */
  private static int getCount(final int[] nums, int target) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res += lessThanOrEquals(nums, nums[i] + target) - i;
    }
    return res;
  }

  private static int lessThanOrEquals(int[] nums, int limit) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (right - left + 1) / 2 + left;
      if (nums[mid] <= limit) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}
