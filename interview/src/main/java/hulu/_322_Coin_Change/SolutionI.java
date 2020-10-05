package hulu._322_Coin_Change;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 12/24/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int coinChange(int[] coins, final int amount) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0 || coins == null || coins.length == 0) {
      return 0;
    }
    final int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i <= amount; ++i) {
      if (dp[i] == Integer.MAX_VALUE) continue;
      for (int coin : coins) {
        final long target = ((long) i) + coin;
        if (target <= amount) {
          final int targetIndex = (int) target;
          dp[targetIndex] = Math.min(dp[targetIndex], dp[i] + 1);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
