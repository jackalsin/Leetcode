package interviews.byteDance._053_Maximum_Subarray;

/**
 * @author zhixi
 * @version 1.0 on 5/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int n = nums.length;
    int maxSumSoFar = nums[0], maxSumEndHere = nums[0];
    for (int i = 1; i < n; ++i) {
      maxSumEndHere = Math.max(nums[i], maxSumEndHere + nums[i]);
      maxSumSoFar = Math.max(maxSumSoFar, maxSumEndHere);
    }
    return maxSumSoFar;
  }
}
