package linkedin._070_Climbing_Stairs;

/**
 * @author jacka
 * @version 1.0 on 8/24/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int climbStairs(int n) {
    final int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 0; i <= n; ++i) {
      if (i + 1 <= n) {
        dp[i + 1] += dp[i];
      }
      if (i + 2 <= n) {
        dp[i + 2] += dp[i];
      }
    }
    return dp[n];
  }
}
