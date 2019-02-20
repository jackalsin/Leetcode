package interviews.airbnb._377_Combination_Sum_IV;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/19/2019.
 */
public final class TopDownSolution implements Solution {
  public int combinationSum4(int[] nums, int target) {
    final int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    dfs(dp, nums, target);
    return dp[target];
  }

  private static int dfs(final int[] dp, final int[] nums, int remain) {
    if (remain < 0) {
      return 0;
    }
    if (remain == 0) {
      return 1;
    }
    if (dp[remain] != -1) {
      return dp[remain];
    }
    int res = 0;
    for (int n : nums) {
      res += dfs(dp, nums, remain - n);
    }
    return dp[remain] = res;
  }
}
