package interviews.oracle._053_Maximum_Subarray;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSoFar = nums[0], maxEndHere = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      int prevSoFar = maxSoFar, prevEndHere = maxEndHere;
      maxEndHere = Math.max(nums[i], prevEndHere + nums[i]);
      maxSoFar = Math.max(prevSoFar, maxEndHere);
    }
    return maxSoFar;
  }
}
