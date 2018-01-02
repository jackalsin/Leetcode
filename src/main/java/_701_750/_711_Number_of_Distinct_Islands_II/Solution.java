package _701_750._711_Number_of_Distinct_Islands_II;

import java.util.Arrays;

public class Solution {

  /**
   * 这道题的最大难点在于是要数unique pair
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

    System.out.println(Arrays.toString(nums));
    while (min < max) {
      int mid = min + (max - min) / 2;
      int curCount = getCount(nums, mid);
      System.out.println("mid = " + mid + " curCount = " + curCount);
      if (curCount < k) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return min;
  }


  private static int getCount(final int[] nums, int target) {
    int count = 0;
    for (int num : nums) {
      count += getCountLessThanOrEquals(nums, num + target);
    }
    return count;
  }

  /**
   * Return the count smaller than or equal to <t>target</t>
   *
   * @param nums
   * @param target
   * @return
   */
  private static int getCountLessThanOrEquals(final int[] nums, final int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (right - left + 1) / 2 + left;
      if (nums[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

}
