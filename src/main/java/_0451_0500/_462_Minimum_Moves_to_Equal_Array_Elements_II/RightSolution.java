package _0451_0500._462_Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.Arrays;

public class RightSolution implements Solution {
  /**
   * 实际上就是找数组中数
   * <p>
   * Time Complexity: O(N Log N)
   * Space Complexity: O(1)
   *
   * @param nums
   * @return
   */
  @Override
  public int minMoves2(int[] nums) {
    int moves = 0;
    Arrays.sort(nums);
    for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
      moves += (nums[end] - nums[start]);
    }
    return moves;
  }
}
