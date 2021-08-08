package linkedin._053_Maximum_Subarray;

/**
 * @author jacka
 * @version 1.0 on 8/21/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int maxSum = nums[0], maxSumEndHere = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      maxSumEndHere = Math.max(maxSumEndHere + nums[i], nums[i]);
      maxSum = Math.max(maxSum, maxSumEndHere);
    }
    return maxSum;
  }
}
