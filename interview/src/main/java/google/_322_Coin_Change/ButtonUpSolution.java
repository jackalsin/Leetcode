package google._322_Coin_Change;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/6/2021
 */
public final class ButtonUpSolution implements Solution {
  @Override
  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0) return -1;
    if (amount <= 0) return 0;
    final int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i <= amount; ++i) {
      for (int coin : coins) {
        if ((long) i + coin > amount || dp[i] == Integer.MAX_VALUE) continue;
        dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
