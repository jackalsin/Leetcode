package _0251_0300._283_Move_Zeroes;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public final class SolutionI implements Solution {
  public void moveZeroes(int[] nums) {
    int nonZeroPtr = 0, zeroPtr = 0;
    for (int num : nums) {
      if (num != 0) nums[nonZeroPtr++] = num;
    }
    for (int i = nonZeroPtr; i < nums.length; ++i) {
      nums[i] = 0;
    }
  }

}
