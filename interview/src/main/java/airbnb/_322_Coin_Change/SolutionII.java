package airbnb._322_Coin_Change;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/28/2021
 */
public final class SolutionII implements Solution {

  public int coinChange(int[] coins, int amount) {
    final int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < amount; ++i) {
      if (dp[i] == Integer.MAX_VALUE) continue;
      for (int c : coins) {
        final long next = (long) i + c;
        if (next <= amount) {
          dp[(int) next] = Math.min(dp[(int) next], dp[i] + 1);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
