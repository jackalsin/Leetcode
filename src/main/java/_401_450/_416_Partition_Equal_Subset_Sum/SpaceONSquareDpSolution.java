package _401_450._416_Partition_Equal_Subset_Sum;

/**
 * This solution take O (N ^ 2) space complexity.
 * https://discuss.leetcode.com/topic/67539/0-1-knapsack-detailed-explanation
 */
public class SpaceONSquareDpSolution implements Solution {

  @Override
  public boolean canPartition(int[] nums) {
    if (nums == null && nums.length == 0) {
      return true;
    }
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if ((sum & 1) == 1) {
      return false;
    }
    int target = sum / 2;
    /* dp[i][j] means the first i can comes to sum j. */
    final boolean[][] dp = new boolean[nums.length + 1][target + 1];
    dp[0][0] = true;
    for (int i = 1; i < nums.length + 1; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < target + 1; i++) {
      dp[0][i] = false;
    }

    for (int i = 1; i < nums.length + 1; i++) {
      for (int j = 1; j < target + 1; j++) {
        dp[i][j] = dp[i - 1][j]; // we don't choose num[i - 1]
        if (nums[i - 1] <= j) {
          // we choose num[i - 1]
          dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[nums.length][target];
  }
}
