package linkedin._322_Coin_Change;

import java.util.Arrays;

public final class DpSolution implements Solution {

  public int coinChange(int[] coins, int amount) {

    final int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= amount; ++i) {
      for (int coin : coins) {
        if (i - coin < 0 || dp[i - coin] == Integer.MAX_VALUE) {
          continue;
        }
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }

    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
