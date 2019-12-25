package interviews.hulu._518_Coin_Change_2;

/**
 * @author jacka
 * @version 1.0 on 12/24/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int change(int amount, int[] coins) {
    if (amount == 0) {
      return 1;
    }
    if (coins == null || coins.length == 0) {
      return 0;
    }
    final int n = coins.length;
    final int[][] dp = new int[n + 1][amount + 1];
    dp[0][0] = 1;
    for (int i = 0; i < n; ++i) {
      for (int a = 0; a <= amount; ++a) {
        dp[i + 1][a] = dp[i][a];
        final int target = a - coins[i];
        if (target >= 0) {
          dp[i + 1][a] += dp[i + 1][target];
        }
      }
    }
    return dp[n][amount];
  }
}
