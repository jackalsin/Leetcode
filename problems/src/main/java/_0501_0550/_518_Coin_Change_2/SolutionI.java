package _0501_0550._518_Coin_Change_2;

/**
 * @author jacka
 * @version 1.0 on 10/13/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int change(int amount, int[] coins) {

    final int[][] dp = new int[coins.length + 1][amount + 1];
    dp[0][0] = 1;
    for (int i = 0; i < coins.length; ++i) {
      final int coin = coins[i];
      dp[i + 1][0] = 1;
      for (int j = 1; j <= amount; ++j) {
        dp[i + 1][j] = dp[i][j] + (j - coin >= 0 ? dp[i + 1][j - coin] : 0);
      }
    }
    return dp[coins.length][amount];
  }
}
