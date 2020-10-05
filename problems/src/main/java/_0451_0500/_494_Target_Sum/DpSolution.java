package _0451_0500._494_Target_Sum;

public final class DpSolution implements Solution {
  @Override
  public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (((sum + S) & 1) == 1) {
      return 0;
    }
    if (sum < S) {
      return 0;
    }
    return subSum(nums, (sum + S) / 2);
  }

  private static int subSum(final int[] nums, final int targetSum) {
    /* dp[i][j] means the sum j can be generate by the first i entry */
    final int[] ddp = new int[targetSum + 1];
    ddp[0] = 1;
    for (int i = 1; i < nums.length + 1; i++) {
      for (int s = targetSum; s >= 0; s--) {
        if (s >= nums[i - 1]) {
          ddp[s] += ddp[s - nums[i - 1]];
        }
      }
    }

    return ddp[targetSum];
  }

  private static int subSum2D(final int[] nums, final int targetSum) {
    /* dp[i][j] means the sum j can be generate by the first i entry */
    final int[][] dp = new int[nums.length + 1][targetSum + 1];
    dp[0][0] = 1;
    for (int i = 1; i < nums.length + 1; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i < nums.length + 1; i++) {
      for (int j = 0; j < targetSum + 1; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j >= nums[i - 1]) {
          dp[i][j] += dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[nums.length][targetSum];
  }
}
