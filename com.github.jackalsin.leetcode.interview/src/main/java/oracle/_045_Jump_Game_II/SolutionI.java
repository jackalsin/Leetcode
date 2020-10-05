package oracle._045_Jump_Game_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int jump(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int n = nums.length;
    final int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < n; ++i) {
      if (dp[i] == Integer.MAX_VALUE) continue;
      for (int k = 1; k <= nums[i] && i + k < n; ++k) {
        dp[i + k] = Math.min(dp[i + k], dp[i] + 1);
      }
    }
    return dp[n - 1];
  }
}
