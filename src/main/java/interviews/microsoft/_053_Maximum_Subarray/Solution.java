package interviews.microsoft._053_Maximum_Subarray;

public class Solution {
  public int maxSubArray(int[] nums) {
    assert nums.length >= 1;
    int maxSoFar = nums[0], maxEndHere = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxEndHere, maxSoFar);
    }
    return maxSoFar;
  }
}
