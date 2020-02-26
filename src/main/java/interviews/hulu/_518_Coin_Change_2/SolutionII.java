package interviews.hulu._518_Coin_Change_2;

/**
 * @author jacka
 * @version 1.0 on 2/25/2020
 */
public final class SolutionII implements Solution {
  /**
   * TODO:
   */
  @Override
  public int change(int amount, int[] coins) {
    if (amount == 0) {
      return 1;
    }
    if (coins.length == 0) {
      return 0;
    }
    final int[][] dp = new int[amount + 1][coins.length + 1];
    dp[0][0] = 1;
    for (int i = 0; i < coins.length; ++i) {
      final int coin = coins[i];
      for (int a = 0; a <= amount; ++a) {
        dp[a][i + 1] = dp[a][i];
        if (a - coin >= 0) {
          dp[a][i + 1] += dp[a - coin][i + 1];
        }
      }
    }
//    TwoDimensionArray.toString(dp);
    return dp[amount][coins.length];
  }
}
