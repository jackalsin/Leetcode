package _301_350._322_Coin_Change;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public final class SolutionII implements Solution {
  /**
   * Recursion Solution
   * <p>
   * Runtime: 42 ms
   *
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange(int[] coins, int amount) {
    // write your code here
    final long[] dp = new long[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int coin : coins) {
      for (int j = coin; j <= amount; ++j) {
        dp[j] = Math.min(dp[j], dp[j - coin] + 1);
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
  }

}
