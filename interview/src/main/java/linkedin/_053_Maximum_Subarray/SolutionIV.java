package linkedin._053_Maximum_Subarray;

/**
 * @author jacka
 * @version 1.0 on 8/21/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSoFar = nums[0], maxEndHere = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }
}
