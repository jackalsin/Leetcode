package interviews.linkedin._053_Maximum_Subarray;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public final class SolutionI implements Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSofar = nums[0], maxEndHere = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
      maxSofar = Math.max(maxSofar, maxEndHere);
    }
    return maxSofar;
  }
}
