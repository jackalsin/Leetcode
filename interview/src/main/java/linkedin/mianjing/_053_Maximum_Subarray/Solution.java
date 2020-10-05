package linkedin.mianjing._053_Maximum_Subarray;

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxEndHere = nums[0], maxSoFar = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }
}
