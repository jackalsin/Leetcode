package uber._053_Maximum_Subarray;

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSoFar = nums[0], maxEndHere = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxEndHere = Math.max(nums[i], maxEndHere + nums[i]);
      maxSoFar = Math.max(maxEndHere, maxSoFar);
    }
    return maxSoFar;
  }
}
