package _451_500._462_Minimum_Moves_to_Equal_Array_Elements_II;

public final class WrongSolution implements Solution {
  public int minMoves2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    int target = (int) (sum / nums.length);
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result += Math.abs(target - nums[i]);
    }
    return result;
  }
}
