package interviews.airbnb._322_Coin_Change;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
public final class Solution {

  public int coinChange(int[] coins, int amount) {
    final int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int a = 0; a <= amount; a++) {
      if (dp[a] == Integer.MAX_VALUE) continue;
      for (int c : coins) {
        if (a + c >= 0 && a + c <= amount) {
          dp[a + c] = Math.min(dp[a + c], dp[a] + 1);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }

}
