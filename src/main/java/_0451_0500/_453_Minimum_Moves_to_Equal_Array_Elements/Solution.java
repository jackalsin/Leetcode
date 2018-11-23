package _0451_0500._453_Minimum_Moves_to_Equal_Array_Elements;

import java.util.Arrays;

public class Solution {
  public int minMoves(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      count += nums[i] - nums[0];
    }
    return count;
  }
}
