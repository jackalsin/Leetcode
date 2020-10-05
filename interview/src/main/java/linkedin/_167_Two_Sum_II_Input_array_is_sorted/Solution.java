package linkedin._167_Two_Sum_II_Input_array_is_sorted;

import java.util.Arrays;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    for (int left = 0, right = nums.length - 1; left < right; ) {
      final int sum = nums[left] + nums[right];
      if (sum < target) {
        left++;
      } else if (sum == target) {
        return new int[]{left + 1, right + 1};
      } else {
        right--;
      }
    }

    throw new IllegalArgumentException("In array " + Arrays.toString(nums));
  }
}
