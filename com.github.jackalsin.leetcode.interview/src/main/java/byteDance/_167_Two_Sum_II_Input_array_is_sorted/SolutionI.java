package byteDance._167_Two_Sum_II_Input_array_is_sorted;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] twoSum(int[] nums, int target) {
    for (int left = 0, right = nums.length - 1; left < right; ) {
      final long sum = (long) nums[left] + nums[right];
      if (sum == target) {
        return new int[]{left + 1, right + 1};
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    throw new IllegalArgumentException("Cannot find 2 elements in " + Arrays.toString(nums) + " that add up to " + target);
  }
}
