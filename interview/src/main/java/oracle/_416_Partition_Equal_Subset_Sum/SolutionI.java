package oracle._416_Partition_Equal_Subset_Sum;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canPartition(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }
    final int n = nums.length;
    long sum = getSum(nums);
    if (sum % 2 == 1) {
      return false;
    }
    assert sum >= 0 && sum <= Integer.MAX_VALUE;
    sum /= 2;
    final boolean[][] dp = new boolean[n + 1][(int) (sum + 1)];
    dp[0][0] = true;
    for (int i = 1; i <= n; ++i) {
      dp[i][0] = true;
      for (int j = 1; j <= sum; ++j) {
        dp[i][j] = dp[i - 1][j];
        if (j >= nums[i - 1]) {
          dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }
//    display(dp);
    return dp[n][(int) sum];
  }

  private static long getSum(final int[] nums) {
    long sum = 0;
    for (int n : nums) {
      sum += n;
    }
    return sum;
  }

}
