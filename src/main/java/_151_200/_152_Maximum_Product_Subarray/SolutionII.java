package _151_200._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public final class SolutionII implements Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int minEndHere = nums[0], maxEndHere = nums[0], maxSoFar = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      final int prevMinEndHere = minEndHere, prevMaxEndHere = maxEndHere;
      maxEndHere = Math.max(nums[i], Math.max(prevMinEndHere * nums[i], prevMaxEndHere * nums[i]));
      minEndHere = Math.min(nums[i], Math.min(prevMinEndHere * nums[i], prevMaxEndHere * nums[i]));
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }
}
