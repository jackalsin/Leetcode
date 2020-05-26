package _0701_0750._746_Min_Cost_Climbing_Stairs;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minCostClimbingStairs(int[] cost) {
    if (cost == null || cost.length < 2) {
      return 0;
    }
    final int n = cost.length;
    final int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = 0;
    for (int i = 0; i < n; ++i) {
      if (i + 1 < n + 1) {
        dp[i + 1] = Math.min(dp[i + 1], dp[i] + cost[i]);
      }
      if (i + 2 < n + 1) {
        dp[i + 2] = Math.min(dp[i] + cost[i], dp[i + 2]);
      }
    }
//    System.out.println(Arrays.toString(dp));
    return dp[n];
  }
}
