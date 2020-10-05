package microsoft.noodleEssence._053_Maximum_Subarray;

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    long minSum = Math.min(nums[0], 0L), curSum = nums[0], maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      curSum += nums[i];
      maxSum = Math.max(maxSum, curSum - minSum);
      minSum = Math.min(minSum, curSum);
    }
    return (int) maxSum;
  }
}
