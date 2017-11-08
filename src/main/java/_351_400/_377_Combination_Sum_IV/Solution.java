package _351_400._377_Combination_Sum_IV;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 11/8/2017.
 */
public class Solution {
  public int combinationSum4(int[] nums, int target) {
    final int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    return helper(dp, nums, target);

  }

  private int helper(final int[] dp, final int[] nums, final int target) {
    if (dp[target] != -1) {
      return dp[target];
    }
    int sum = 0;
    for (int num : nums) {
      if (target >= num) {
        sum += helper(dp, nums, target - num);
      }
    }
    dp[target] = sum;
    return sum;
  }
}
