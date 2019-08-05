package interviews.linkedin._070_Climbing_Stairs;

public final class SolutionI implements Solution {
  public int climbStairs(int n) {
    final int[] dp = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; ++i) {
      dp[i] = dp[i - 1] + (i > 1 ? dp[i - 2] : 0);
    }
    return dp[n];
  }
}
