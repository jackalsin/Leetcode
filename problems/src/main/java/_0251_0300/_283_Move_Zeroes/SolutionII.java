package _0251_0300._283_Move_Zeroes;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class SolutionII implements Solution {
  @Override
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int nonZeroPtr = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != 0) {
        nums[nonZeroPtr++] = nums[i];
      }
    }
    for (int i = nonZeroPtr; i < nums.length; ++i) {
      nums[i] = 0;
    }
  }
}
