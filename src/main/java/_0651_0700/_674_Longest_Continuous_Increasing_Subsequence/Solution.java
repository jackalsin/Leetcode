package _0651_0700._674_Longest_Continuous_Increasing_Subsequence;

public class Solution {
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int prev = nums[0], count = 1, maxCount = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > prev) {
        count++;
        maxCount = Math.max(maxCount, count);
      } else {
        count = 1;
      }
      prev = nums[i];
    }

    return maxCount;
  }

}
