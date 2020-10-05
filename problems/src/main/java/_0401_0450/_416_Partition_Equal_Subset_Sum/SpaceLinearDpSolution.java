package _0401_0450._416_Partition_Equal_Subset_Sum;

public class SpaceLinearDpSolution implements Solution {
  @Override
  public boolean canPartition(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }

    int sum = 0;
    for (int i : nums) {
      sum += i;
    }

    if ((sum & 1) == 1) {
      return false;
    }
    sum = sum / 2;

//    final boolean[][] dp = new boolean[nums.length + 1][sum + 1];
//    dp[0][0] = true;
//    for (int i = 1; i < nums.length + 1; i++) {
//      dp[i][0] = true;
//    }
//
//    for (int i = 1; i < sum + 1; i++) {
//      dp[0][i] = false;
//    }
//
//    for (int i = 1; i < nums.length + 1; i++) {
//      for (int j = 1; j < sum + 1; j++) {
//        dp[i][j] = dp[i - 1][j];
//        if (nums[i - 1] <= j) {
//          dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i - 1]];
//        }
//      }
//    }

    final boolean[] ddp = new boolean[sum + 1];
    ddp[0] = true;
    for (int num : nums) {
      for (int s = sum; s >= 0; s--) {
        if (s >= num) {
          ddp[s] = ddp[s] | ddp[s - num];
        }
      }
    }
    return ddp[sum];
  }
}
