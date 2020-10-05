package oracle._322_Coin_Change;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 12/8/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int coinChange(int[] coins, int amount) {
    final int[] dp = new int[amount + 1];
    if (amount == 0) {
      return 0;
    }
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i <= amount; ++i) {
      if (dp[i] == Integer.MAX_VALUE) continue;
      for (int coin : coins) {
        final int target = i + coin;
        if (target > amount || target < 0) {
          continue;
        }
        dp[target] = Math.min(dp[target], dp[i] + 1);
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
